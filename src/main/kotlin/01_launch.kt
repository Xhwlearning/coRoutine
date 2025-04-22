import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
    //实例化协程对象
    val scope = CoroutineScope(EmptyCoroutineContext)
    //job是协程对象scope返回的对象，其可以监测该协程的状态，launch创建一个协程
    val job : Job= scope.launch{
        println("Coroutine name:${Thread.currentThread().name}")
    }
    runBlocking {
        //挂起函数，等待协程执行完毕
        job.join()
    }
}