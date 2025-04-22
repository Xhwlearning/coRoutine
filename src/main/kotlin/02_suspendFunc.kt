import kotlinx.coroutines.*
//withContext保证协程内部串行执行，如果再用launch，其是并行执行的
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