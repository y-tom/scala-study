// 部分和問題を再帰（深さ優先探索）で解く
 /**
   * index 番目以降の要素について
   * 「選ぶ / 選ばない」を試しながら、
   * 和が k になる組み合わせが存在するかを探索する再帰関数
   *
   * @param index   現在見ている配列の位置
   * @param partial これまでに「選んだ」要素の集合
   * @return (見つかったかどうか, 見つかった場合の組み合わせ)
   */

object PartialSumDFS extends App {

  // 入力データ
  val a = Seq(3, 6, -5, 7)
  val n = a.length
  val k = 8

  def isMatchAndResult(index: Int, partial: Seq[Int]): (Boolean, Seq[Int]) = {

    // --- 再帰の終了条件 ---
    // すべての要素について「選ぶ / 選ばない」を決め終えた場合
    if (index == n) {
      // 合計が k なら成功、それ以外は失敗
      return if (partial.sum == k) (true, partial)
             else (false, Seq())
    }

    // --- 現在の要素 a(index) を「選ばない」ルート ---
    // 次の index に進み、partial はそのまま
    val (isMatchNotAdd, resultNotAdd) =
      isMatchAndResult(index + 1, partial)

    // すでに解が見つかっていれば、それ以上探索せず結果を返す
    if (isMatchNotAdd) {
      return (isMatchNotAdd, resultNotAdd)
    }

    // --- 現在の要素 a(index) を「選ぶ」ルート ---
    // partial に a(index) を追加して次へ進む（元の partial は不変）
    isMatchAndResult(index + 1, partial :+ a(index))
  }

  // --- 再帰の開始（エントリーポイント） ---
  // index = 0（最初の要素から）
  // partial = Seq()（まだ何も選んでいない状態）
  val (isMatch, result) = isMatchAndResult(0, Seq())

  // 結果の出力
  if (isMatch) println(s"Yes $result") else println("No")
}
