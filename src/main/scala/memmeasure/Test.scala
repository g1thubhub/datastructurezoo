package memmeasure

import memmeasure.spark.JvmSizeEstimator

object Test extends App  {
  println(JvmSizeEstimator.estimate(new Object()))
}
