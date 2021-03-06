/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sparkAlgos.mllib.clustering

import org.apache.spark.SparkContext


/**
 * Driver for the OutlierWithAVFModel 
 *
 **/
object Test{

  def main(args:Array[String])
  {
    val sc = new SparkContext("local", "OutlierDetection")
    val dir = "/home/ashu/Desktop/abc.txt"//"hdfs://localhost:54310/train3"//


    val data = sc.textFile(dir).map(word => word.split(",").toVector)
    val model = OutlierWithAVFModel.outliers(data,30,sc) //"hdfs://localhost:54310/train3"

    model.score.saveAsTextFile("/home/ashu/Desktop/sc")
    model.trimedData.saveAsTextFile("/home/ashu/Desktop/tri")
    model.outliers.saveAsTextFile("/home/ashu/Desktop/outs")

  }

}