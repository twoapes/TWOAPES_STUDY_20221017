# ReadWriteLock是什么?

如果使用ReentrantLock,可能本身是为了防止线程A在写数据,线程B在读数据造成的数据不一致,
但这样,如果线程C在读数据,线程D也在读数据,读数据是不会改变数据的,没有必要加锁,但是还是加锁了,降低了程序的性能.

因为这个,才诞生了读写锁ReadWriteLock.

ReadWriteLock是一个读写锁接口

ReentrantReadWriteLock是ReadWriteLock接口的一个具体实现

实现了读写的分离,读锁是共享的,写锁是独占的,读和读之间不会互斥,读和写,写和读,写和写之间才会互斥,提升了读写的性能.
