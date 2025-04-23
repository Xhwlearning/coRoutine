import kotlinx.coroutines.*
/*
    1. async 返回 Deferred (一个带结果的 Job)，launch 返回 Job (不带结果)。
       因此，当有多个网络请求需要并发获取，最后合并显示的话，就需要使用async的await()。
    2. coroutineScope本身是一个挂起函数，面向结构化并发，优点如下：
        1. 强制等待所有子任务完成：`coroutineScope` 会挂起外部协程，确保作用域内的所有任务完成后再继续执行后续代码。
        2. 统一取消：如果外部协程被取消，`coroutineScope` 内的所有子任务也会立即取消，避免孤儿协程。
        3. 故障隔离：内部任务失败时，`coroutineScope` 会取消其他子任务，并将异常向外传播，避免影响外部不相关任务。
 */
fun main(): kotlin.Unit = runBlocking{
//    //async：asynchronous异步。{}中最后一条表达式的值就是这个 async 任务最终计算出的结果。
//    val str1 = async {
//        "str1"
//    }
//    val str2 = async {
//        "str2"
//    }
//    launch {
//    //当调用 deferred.await() 时，当前的协程会挂起，直到 deferred 所代表的那个 async 任务执行完成并产生结果。
//        val string1 = str1.await()
//        val string2 = str2.await()
//        println(string1 + string2)
//    }
    //简化上述代码：
    launch{
        coroutineScope {
            val deferred1 = async{"str1"}
            val deferred2 = async{"str2"}
            println(deferred1.await() + deferred2.await())
        }
    }
}