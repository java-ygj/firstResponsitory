package com.atguigu.myrule;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RoundRobinRule_YGJ extends AbstractLoadBalancerRule {

	private int total = 0;
	private int currentIndex = 0;

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;// server为null

		while (server == null) {// server为null则进入循环
			if (Thread.interrupted()) {
				//中断此线程（此线程不一定是当前线程，而是指调用该方法的Thread实例所代表的线程）
				return null;
			}
			List<Server> upList = lb.getReachableServers();// 还存活的线程
			List<Server> allList = lb.getAllServers();// 所有的线程

			int serverCount = allList.size();// 所有线程的总数
			if (serverCount == 0) {
				/*
				 * No servers. End regardless of pass, because subsequent passes only get more
				 * restrictive.
				 */
				return null;
			}

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);
			if(total<5) 
			{
				server = upList.get(currentIndex);
				total++;
			}else 
			{
				total=0;
				currentIndex++;
				if(currentIndex>=upList.size())
				{
					currentIndex=0;
				}
			}
			
			
			if (server == null) {
				/*
				 * The only time this should happen is if the server list were somehow trimmed.
				 * This is a transient condition. Retry after yielding.
				 */
				Thread.yield();// 是当前线程从运行状态，进入就绪状态。
				continue;
			}

			if (server.isAlive()) {
				return (server);
			}

			// Shouldn't actually happen.. but must be transient or a bug.
			server = null;
			Thread.yield();
		}

		return server;

	}

	protected int chooseRandomInt(int serverCount) {
		return ThreadLocalRandom.current().nextInt(serverCount);
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub

	}
}