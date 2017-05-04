package com.hector.learn.zookeeper.curator;

import java.util.Collection;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceType;
import org.apache.curator.x.discovery.details.InstanceSerializer;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;


public class ZKServiceDiscovery {
	private static String address = "localhost:2181";
	private static String basePath="/test";
	private final static InstanceSerializer serializer = new JsonInstanceSerializer<>(ServiceInfo.class);
	private static ServiceDiscovery discovery ;

	public static void main(String[] args) {
		CuratorFramework client = CuratorFrameworkFactory.newClient(address, new ExponentialBackoffRetry(1000,3));
		client.start();
		
		discovery = ServiceDiscoveryBuilder.builder(ServiceInfo.class)
									.basePath(basePath)
									//.serializer(serializer)
									.client(client).build();
		try {
			discovery.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ServiceInstance service = new ServiceInstance<ServiceInfo>("testSevice", null, "192.168.1.32", 5200, 0, null,0 , ServiceType.DYNAMIC, null);
		ServiceInstance<ServiceInfo> service = null;
		try {
			service = ServiceInstance.<ServiceInfo>builder()
				.name("testSevice")
				.address("192.168.1.32")
				.port(9000)
				//.serviceType(serviceType)
				.build();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			discovery.registerService(service);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Collection c = discovery.queryForInstances("testSevice");
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		synchronized(ZKServiceDiscovery.class){
			try {
				ZKServiceDiscovery.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void registerService(ServiceInstance service) throws Exception {
		discovery.registerService(service);
	}

}
