class Quiz (var a: String, var q: List[String]){

  implicit class RichIterable[A](xs: Iterable[A]){

    def zipWith[B, C] (ys: Iterable[B])(op: (A, B) => C): Iterable[C]={
      (xs zip ys) map{case (x, y) => op(x, y)}
    }
  }

  var correct = ""

  def printAnnounce: Unit =
    println("\n問題 : " ++ a)

  def printQuiz: Unit ={
    val l = List("\n1: ", "2: ", "3: ", "4: ")
    l.zipWith(q)((x, y) => x ++ y).map(println)
  }

  def setAnswer(n: String): Unit=
    correct = n

  def isCorrect(s: String): Boolean=
    if(s == correct) true
    else false

  def validator(n: String): Boolean= {
    val l = List("1", "2", "3", "4")
    l.contains(n)
  }

}
