// 部分和問題をビット演算（全探索）で解く
object PartialSumBitOp extends App {

  // ---- 数列、目標値、フラグ、ビット列、ビット列最大値を用意 ----
  // 数列 a と目標値 k
  val a = Seq(3, 6, -5, 7)
  val n = a.length
  val k = 8

  // 解が見つかったかどうかのフラグ
  var isMatch = false

  // 現在調べている「選ぶ / 選ばない」の状態を表すビット列
  // 例: 0101 → 0番目と2番目を選ぶ
  var bitsCounter = 0

  // ビット列のカウンターの最大値
  // -1（＝nビットすべてが 1の値）をnビット左にシフト（＝下位nビットが0）、さらに反転して下位nビットが1になる
  // << は ビット左シフト演算子（left shift）
  val max = ~(-1 << n)

  // ---- 全探索の開始 ----
  // bitsCounter を 0 から max まで 1 ずつ進めながら、和が k になる組み合わせがあるかを全探索する
  while (!isMatch && bitsCounter <= max) {

    // 現在のビット列（bitsCounter）に対応する部分和（合計値）
    var sum = 0

    // iを0からn-1ままでループし、各要素 a(i) が「選ばれているか」をビットで確認する
    for (i <- 0 to (n - 1)) {

      // maskは、1をiビット左にシフトしてi番目のビットだけが 1 のビットマスク
      // あとでbitsCounterの1の場所を特定（bitsCounterのi番目のビットが1かどうかを判別）するのに使う
      val mask = 1 << i

      // bitsCounter & mask で、maskで1にした場所（桁）が、bitsCounterで1かどうかを確認する
      // &なので、同じ桁の箇所がbitsCounterもmaskも両方1でないと、maskedで1にならない
      val masked = bitsCounter & mask

      // i ビット目が 1 → a(i) を選んでいる
      if (masked != 0) {
        sum = sum + a(i)
      }
    }

    // 和が k に一致したら探索成功
    if (sum == k) {
      isMatch = true
    } else {
      // 見つからなければ次のビットパターンへ
      bitsCounter = bitsCounter + 1
    }
  }

  // ---- 結果の復元 ----
  if (isMatch) {
    var result: Seq[Int] = Seq()
    // 見つかった bitsCounter をもとに、
    // 実際に選ばれていた要素を取り出す
    for (i <- 0 to (n - 1)) {
      val mask = 1 << i
      val masked = bitsCounter & mask
      if (masked != 0) {
        result = result :+ a(i)
      }
    }
    println(s"Yes ${result}")
  } else {
    // 全パターンを試しても見つからなかった場合
    println("No")
  }
}
