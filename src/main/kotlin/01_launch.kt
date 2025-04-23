import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext
/*
    CoroutineScope 是 Kotlin 协程库 (kotlinx.coroutines) 中的一个接口。它的核心功能和作用是：
        1. 定义协程的边界：它创建了一个结构化的范围，所有在这个范围内启动的协程都受其管理。
        2. 管理协程生命周期：它负责追踪并控制其内部启动的所有协程的生命周期，特别是处理取消操作。
        3. 提供协程上下文 (CoroutineContext)：它持有一个 CoroutineContext，这个上下文会被其内部启动的所有子协程
           继承，<定义了协程运行的基础环境（如调度器、Job 等）>。
        4. 简单来说，CoroutineScope 为协程提供了一个结构化的 “家”，确保它们不会 “失控” 或 “泄漏”。

 */

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