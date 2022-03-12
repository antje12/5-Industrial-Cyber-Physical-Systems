package dk.sdu.mmmi.milo.test;

import java.util.List;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

public class Read {
    public static void main(String[] args) {
            try 
            {
                List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://localhost:53530/OPCUA/SimulationServer").get();

                OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
                cfg.setEndpoint(endpoints.get(0));

                OpcUaClient client = OpcUaClient.create(cfg.build());
                client.connect().get();

                NodeId nodeId = NodeId.parse("ns=3;i=1008");

                DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId)
                        .get();
                System.out.println("DataValue= " + dataValue);

                Variant variant = dataValue.getValue();
                
                System.out.println("Variant= " + variant);

                int random = (int)variant.getValue();
                System.out.println("myVariable= " + random);
            }
            catch(Throwable ex)
            {
                ex.printStackTrace();
            }
    }
}