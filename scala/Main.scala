object Main {

  private def loopValidator(n: String => Boolean, m: String): String ={
    val s = io.StdIn.readLine()
    if(!n(s)) {
      println(m)
      loopValidator(n, m)
    }
    else s
  }

  private def quizRoutine(q: Quiz): Boolean={
    q.printAnnounce
    q.printQuiz
    println("Your Answer: ")
    val m = "1 から 4 の数値を入力してください。"
    val a = loopValidator(q.validator, m)
    q.isCorrect(a)
  }

  def main(args: Array[String]): Unit = {

    println("Welcome Scala App")
    println("could you write your name ?")
    val greeting = (s: String) => "WELCOME %s, HELLO WORLD".format(s)
    println(greeting(io.StdIn.readLine()))
    println("\n*******************************")
    println("          Start Quiz           ")
    println("*******************************")

    val a1 = "世界で一番貧しい国は？"
    val l1 = List("ルワンダ", "南スーダン", "アルメニア", "ボツワナ")
    val q1 = new Quiz(a1, l1)
    q1.setAnswer("2")

    val a2 = "世界で一番広い国は？"
    val l2 = List("アメリカ", "カナダ", "中国", "ロシア")
    val q2 = new Quiz(a2, l2)
    q2.setAnswer("4")

    val a3 = "世界で一番物価が高い国は？"
    val l3 = List("フィンランド", "イスラエル", "アイスランド", "イギリス")
    val q3 = new Quiz(a3, l3)
    q3.setAnswer("3")

    val a4 = "世界で一番治安の良い国は？"
    val l4 = List("台湾", "スイス", "日本", "カタール")
    val q4 = new Quiz(a4, l4)
    q4.setAnswer("4")

    val ql = List(q1,q2,q3,q4)
    val count = ql.map(quizRoutine).filter(x => x == true).length
    val correctCounter = (n: Int) => "\n正解した数は %d　問です！".format(n)
    println(correctCounter(count))

  }
}

