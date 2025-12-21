error id: file:///C:/Users/Yukako/workspace/scala-study/SimpleSearch.scala:scala/package.Seq#
file:///C:/Users/Yukako/workspace/scala-study/SimpleSearch.scala
empty definition using pc, found symbol in pc: scala/package.Seq#
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Seq#
	 -scala/Predef.Seq#
offset: 216
uri: file:///C:/Users/Yukako/workspace/scala-study/SimpleSearch.scala
text:
```scala
object SimpleSearch extends App {
  val text = "カワカドカドカドドワンゴカドカドンゴドワドワンゴドワカワカドンゴドワ".toSeq
  val pattern = "ドワンゴ".toSeq
  val matchIndexes = search(text, pattern)

  def search(text: Seq[Char], pattern: Seq[Char]): Se@@q[Int] = {
    var matchIndexes = Seq[Int]()
    for (i <- 0 to text.length - 1) {
      val partText = text.slice(i, i + pattern.length)
      if (isMatch(partText, pattern)) matchIndexes = matchIndexes :+ i
    }
    matchIndexes
  }

  def isMatch(textPart: Seq[Char], pattern: Seq[Char]): Boolean = {
    var isMatch = true
    for (i <- 0 to pattern.length - 1) {
      if (textPart.length < pattern.length || textPart(i) != pattern(i)) isMatch = false
    }
    isMatch
  }

  println(s"出現場所: ${matchIndexes}")
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/package.Seq#