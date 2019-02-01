# test-aries-coordination
This project shows an issue with Aries JPA Blueprint.

## Usage

Build the project with Maven :

```sh
mvn install
```

Launch Karaf 4.2.2 and install the project kar :
```sh
karaf@root()> feature:install jpa transaction hibernate jdbc pax-jdbc-hsqldb
karaf@root()> jdbc:ds-create -dn hsqldb -url "jdbc:hsqldb:mem:testdb" -u sa jdbc/testdb
karaf@root()> kar:install mvn:com.dutertry.test.aries.coordination/test-aries-coordination-kar/1.0.0-SNAPSHOT/kar
```

Execute person:create command :
```sh
karaf@root()> person:create Test 20
```

You will see the following error :
```sh
Error executing command: Cannot add Participant org.apache.aries.jpa.support.impl.EMSupplierImpl$EmShutDownParticipant@62c176b8 to terminated Coordination
```

In karaf.log :
```
org.osgi.service.coordinator.CoordinationException: Cannot add Participant org.apache.aries.jpa.support.impl.EMSupplierImpl$EmShutDownParticipant@62c176b8 to terminated Coordination
	at org.apache.felix.coordinator.impl.CoordinationImpl.addParticipant(CoordinationImpl.java:320) ~[?:?]
	at org.apache.felix.coordinator.impl.CoordinationHolder.addParticipant(CoordinationHolder.java:49) ~[?:?]
	at org.apache.aries.jpa.support.impl.EMSupplierImpl.get(EMSupplierImpl.java:89) ~[?:?]
	at org.apache.aries.jpa.support.osgi.impl.EmProxy.invoke(EmProxy.java:38) ~[?:?]
	at com.sun.proxy.$Proxy76.persist(Unknown Source) ~[?:?]
	at Proxyfa602d42_6dbc_4d4a_aab5_0688e37ce713.persist(Unknown Source) ~[?:?]
	at com.dutertry.test.aries.coordination.service.impl.TestRepository.create(TestRepository.java:21) ~[?:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[?:?]
	at org.apache.aries.proxy.impl.ProxyHandler$1.invoke(ProxyHandler.java:54) ~[?:?]
	at org.apache.aries.proxy.impl.ProxyHandler.invoke(ProxyHandler.java:119) ~[?:?]
	at com.dutertry.test.aries.coordination.service.impl.$TestRepository1340653767.create(Unknown Source) ~[?:?]
	at com.dutertry.test.aries.coordination.service.impl.TestServiceImpl.create(TestServiceImpl.java:31) ~[?:?]
	at com.dutertry.test.aries.coordination.cmd.CreatePersonCommand.execute(CreatePersonCommand.java:34) ~[?:?]
	at org.apache.karaf.shell.impl.action.command.ActionCommand.execute(ActionCommand.java:84) ~[?:?]
	at org.apache.karaf.shell.impl.console.osgi.secured.SecuredCommand.execute(SecuredCommand.java:68) ~[?:?]
	at org.apache.karaf.shell.impl.console.osgi.secured.SecuredCommand.execute(SecuredCommand.java:86) ~[?:?]
	at org.apache.felix.gogo.runtime.Closure.executeCmd(Closure.java:599) ~[?:?]
	at org.apache.felix.gogo.runtime.Closure.executeStatement(Closure.java:526) ~[?:?]
	at org.apache.felix.gogo.runtime.Closure.execute(Closure.java:415) ~[?:?]
	at org.apache.felix.gogo.runtime.Pipe.doCall(Pipe.java:416) ~[?:?]
	at org.apache.felix.gogo.runtime.Pipe.call(Pipe.java:229) ~[?:?]
	at org.apache.felix.gogo.runtime.Pipe.call(Pipe.java:59) ~[?:?]
	at java.util.concurrent.FutureTask.run(FutureTask.java:266) ~[?:?]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) ~[?:?]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) ~[?:?]
	at java.lang.Thread.run(Thread.java:748) [?:?]
Caused by: com.dutertry.test.aries.coordination.service.impl.PersonNotFoundException
	at com.dutertry.test.aries.coordination.service.impl.TestRepository.get(TestRepository.java:27) ~[?:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[?:?]
	at org.apache.aries.proxy.impl.ProxyHandler$1.invoke(ProxyHandler.java:54) ~[?:?]
	at org.apache.aries.proxy.impl.ProxyHandler.invoke(ProxyHandler.java:119) ~[?:?]
	at com.dutertry.test.aries.coordination.service.impl.$TestRepository1340653767.get(Unknown Source) ~[?:?]
	at com.dutertry.test.aries.coordination.service.impl.TestServiceImpl.create(TestServiceImpl.java:25) ~[?:?]
	... 14 more
```
