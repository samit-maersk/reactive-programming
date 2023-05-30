# Reactive Programming
- It is new programming paradigm
- Asynchronous and non-blocking
- Event / Message driven
- Functional code style
- Back Pressure on Data Streams

With Spring webflux We can achieve above things.
projectreactor is behind Webflux.

# Reactive Streams
- Publisher
```java
public interface Publisher<T> {
    public void subscribe(Subscriber<? super T> s);
}
```
- Subscriber
```java
public interface Subscriber<T> {
    public void onSubscribe(Subscription s);
    public void onNext(T t);
    public void onError(Throwable t);
    public void onComplete();
}
```
- Subscription
```java
public interface Subscription {
    public void request(long n);
    public void cancel();
}
```
- Processor
```java
public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {
}
```
These are interface to achieve reactive streams


# Flux and Mono
- These are reactive types that implements Reactive Streams Specification
- Part of Reactive-core module
- Flux represents 0..N elements
- Mono represents 0..1 element


