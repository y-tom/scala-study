error id: file:///C:/Users/Yukako/workspace/scala-study/Factorization.scala:scala/collection/MapOps#getOrElse().
file:///C:/Users/Yukako/workspace/scala-study/Factorization.scala
empty definition using pc, found symbol in pc: scala/collection/MapOps#getOrElse().
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -acc/getOrElse.
	 -acc/getOrElse#
	 -acc/getOrElse().
	 -scala/Predef.acc.getOrElse.
	 -scala/Predef.acc.getOrElse#
	 -scala/Predef.acc.getOrElse().
offset: 362
uri: file:///C:/Users/Yukako/workspace/scala-study/Factorization.scala
text:
```scala
import scala.math.sqrt

object Factorization extends App {
  val target = 24
  val maxDivisor = sqrt(target).toInt

def factorizationRec(num: Int, divisor: Int, acc: Map[Int, Int]): Map[Int, Int] = {
    if (divisor > maxDivisor) {
      if (num == 1) acc else acc + (num -> 1)
    } else if (num % divisor == 0) {
      val nextAcc = acc + (divisor -> (acc.getO@@rElse(divisor, 0) + 1))
      factorizationRec(num / divisor, divisor, nextAcc)
    } else {
      factorizationRec(num, divisor + 1, acc)
    }
  }

  println(factorizationRec(target, 2, Map()))
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/collection/MapOps#getOrElse().