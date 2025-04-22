import kotlinx.coroutines.*
//1. withContext保证协程内部串行执行，如果再用launch，其是并行执行的
//2. 协程代码本质是在编译阶段变为了回调形式
/*3. 主线程上开启的协程进行挂起切换后，主线程不会等待新线程执行完毕，而是反复刷新界面获取新任务；等挂起函数执行完会
    抛出一个新任务给主线程的任务队列，主线程则会恢复该协程的执行。*/
fun main(){
    val job : Job = CoroutineScope(Dispatchers.Default).launch {
        println("1:${Thread.currentThread().name}")
        withContext(Dispatchers.IO){
            delay(1000)
            println("2:${Thread.currentThread().name}")
        }
        println("3:${Thread.currentThread().name}")
    }
    runBlocking {
        job.join()
    }
}