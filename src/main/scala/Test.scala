package main.scala

/**
  * Created by tomerb on 26/11/15.
  */
class Test {
  if (oldScoreInfo == null) {
    logger.trace("isScoreWithHigherImportance oldScoreData is null")
    true
  } else {
    val oldScoreReason = oldScoreInfo.scoreReason
    val newScoreReason = newScoreInfo.scoreReason
    val whetherToOverride = (oldScoreReason, newScoreReason) match {
      case (`realScoringServerToken`, `realScoringServerToken`) => oldScoreInfo.requestTimestamp <= newScoreInfo.requestTimestamp
      case (`realScoringServerToken`, `defaultScoringServerToken`) => false
      case (`realScoringServerToken`, `sharkletDefaultScore`) => false

      case (`defaultScoringServerToken`, `realScoringServerToken`) => true
      case (`defaultScoringServerToken`, `defaultScoringServerToken`) => false
      case (`defaultScoringServerToken`, `sharkletDefaultScore`) => false

      case (`sharkletDefaultScore`, _) => true
      case (_, `sharkletDefaultScore`) => false
      case (_, _) => oldScoreInfo.requestTimestamp <= newScoreInfo.requestTimestamp

    }
    logger.trace(s"isScoreWithHigherImportance ((oldScoreReason: $oldScoreReason ,newScoreReason: $newScoreReason) => whetherToOverride: $whetherToOverride)")
    whetherToOverride
  }
}
