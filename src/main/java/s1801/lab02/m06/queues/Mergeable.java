package s1801.lab02.m06.queues;

public interface Mergeable<T> {

    Mergeable<T> merge(Mergeable<T> q1, Mergeable<T> q2);
}
