/**
  * Created by yosuke on 7/15/16.
  */
object ScalaThread {
  class ThreadSample(name: String) extends Runnable {
    def run() = {
      for (i <- 0 to 3) {
        println(name + "count=" + i)
        Thread.sleep(1000)
      }
    }
  }
  def main(args: Array[String]): Unit ={
    println("ThreadSample#main start")
    val t: Array[Thread] = new Array[Thread](3)
    for (i <- 0 until 3) {
      t(i) = new Thread(new ThreadSample("[Thread-" + i + "]"))
      t(i).start()
    }
    for(i <- 0 until 3)
      t(i).join
    println("ThreadSample#main end")
  }
}


