package containers

import java.util.{HashMap => JHashMap, LinkedHashMap => JLinkedHashMap, TreeMap => JTreeMap, WeakHashMap => JWeakHashMap}

import scala.collection.immutable.{HashMap, ListMap, TreeMap}
import scala.collection.mutable

trait ContainerKV[K, V] {

  def existsBatch(keys: Seq[K]): Int

  def retrieveBatch(keys: Seq[K]): Int

  def insertBatch(eles: Seq[(K, V)]): ContainerKV[K, V]

  def deleteBatch(keys: Seq[K]): ContainerKV[K, V]

  val hasCapacity: Boolean

  def initializeWithCapacity(capacity: Int): ContainerKV[K, V]

  def getUnderlyingStorage(): Object // for convenient memory measurements

}


object ContainerKV {
  val kvJdkStructures = List[String]("HashMapContainerKV", "HashMapContainerKVM", "HashMapContainerKVJ",
    "ListMapContainerKV", "ListMapContainerKVM", "TreeMapContainerKV", "TreeMapContainerKVM", "TreeMapContainerKVJ",
    "LinkedHMapContainerKVM", "LinkedHMapContainerKVJ", "WeakHMapContainerKVJ")

  def getEmptyKv[K, V](container: String)(implicit ord: Ordering[K]) = container match {
    case "HashMapContainerKV" => new HashMapContainerKV[K, V]()
    case "HashMapContainerKVM" => new HashMapContainerKVM[K, V]()
    case "HashMapContainerKVJ" => new HashMapContainerKVJ[K, V]()
    case "ListMapContainerKV" => new  ListMapContainerKV[K, V]() // not suitable for more than 100k elements
    case "ListMapContainerKVM" => new  ListMapContainerKVM[K, V]() // not suitable for more than 100k elements
    case "TreeMapContainerKV" => new TreeMapContainerKV[K, V]()
    case "TreeMapContainerKVM" => new TreeMapContainerKVM[K, V]()
    case "TreeMapContainerKVJ" => new TreeMapContainerKVJ[K, V]()
    case "LinkedHMapContainerKVM" => new LinkedHMapContainerKVM[K, V]()
    case "LinkedHMapContainerKVJ" => new LinkedHMapContainerKVJ[K, V]()
    case "WeakHMapContainerKVJ" => new WeakHMapContainerKVJ[K, V]()
  }


  val kv3rdPartyII = List[String](
    "HashHppcContainerII",
    "HashFastutilContainerII",
    "HashKolobokeContainerII",
    "HashEclipseContainerII",
  )

  val kv3rdPartyOF = List[String](
    "HashHppcContainerOF",
    "HashFastutilContainerOF",
    "HashKolobokeContainerOF",
    "HashEclipseContainerOF"
  )


  def getEmpty3rdKvII(container: String) = container match {
    case "HashHppcContainerII" => new HashHppcContainerII()
    case "HashFastutilContainerII" => new HashFastutilContainerII()
    case "HashKolobokeContainerII" => new HashKolobokeContainerII()
    case "HashEclipseContainerII" => new HashEclipseContainerII()
  }

  def getEmpty3rdKvOF[K](container: String) = container match {
    case "HashHppcContainerOF" => new HashHppcContainerOF[String]()
    case "HashFastutilContainerOF" => new HashFastutilContainerOF[String]()
    case "HashKolobokeContainerOF" => new HashKolobokeContainerOF[String]()
    case "HashEclipseContainerOF" => new HashEclipseContainerOF[String]()
  }


}

class HashMapContainerKV[A, B](var elements: HashMap[A, B] = HashMap.empty[A, B]) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.contains(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key).isDefined)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements = elements + ele
    }
    this
  }

  override def deleteBatch(eles: Seq[A]): ContainerKV[A, B] = {
    for (ele <- eles) {
      elements = elements - ele
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}

class HashMapContainerKVM[A, B](elements: mutable.HashMap[A, B] = mutable.HashMap.empty[A, B]) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.contains(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key).isDefined)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements += ele
    }
    this
  }

  override def deleteBatch(keys: Seq[A]): ContainerKV[A, B] = {
    for (key <- keys) {
      elements -= key
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}

class HashMapContainerKVJ[A, B](var elements: JHashMap[A, B] = new JHashMap[A, B]()) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != null)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[A]): ContainerKV[A, B] = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new JHashMap[A, B](Math.ceil(capacity / 0.75).toInt)
    this
  }

  override def getUnderlyingStorage() = elements
}


class ListMapContainerKV[A, B](var elements: ListMap[A, B] = ListMap.empty[A, B]) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.contains(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key).isDefined)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements = elements + ele
    }
    this
  }

  override def deleteBatch(eles: Seq[A]): ContainerKV[A, B] = {
    for (ele <- eles) {
      elements = elements - ele
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}

class ListMapContainerKVM[A, B](elements: mutable.ListMap[A, B] = mutable.ListMap.empty[A, B]) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.contains(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key).isDefined)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements += (ele._1 -> ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[A]): ContainerKV[A, B] = {
    for (key <- keys) {
      elements -= key
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}


class TreeMapContainerKV[A, B](implicit ordering: Ordering[A]) extends ContainerKV[A, B] {
  var elements: TreeMap[A, B] = TreeMap.empty[A, B]

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.contains(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key).isDefined)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements = elements + ele
    }
    this
  }

  override def deleteBatch(eles: Seq[A]): ContainerKV[A, B] = {
    for (ele <- eles) {
      elements = elements - ele
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}


class TreeMapContainerKVM[A, B](implicit ordering: Ordering[A]) extends ContainerKV[A, B] {
  val elements: mutable.TreeMap[A, B] = mutable.TreeMap.empty[A, B]

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.contains(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key).isDefined)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements += (ele._1 -> ele._2)
    }
    this
  }

  override def deleteBatch(eles: Seq[A]): ContainerKV[A, B] = {
    for (ele <- eles) {
      elements -= ele
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}


class TreeMapContainerKVJ[A, B](val elements: JTreeMap[A, B] = new JTreeMap[A, B]()) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != null)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[A]): ContainerKV[A, B] = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}


class LinkedHMapContainerKVM[A, B](val elements: mutable.LinkedHashMap[A, B] = new mutable.LinkedHashMap[A, B]()) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.contains(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key).isDefined)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements += (ele._1 -> ele._2)
    }
    this
  }

  override def deleteBatch(eles: Seq[A]): ContainerKV[A, B] = {
    for (ele <- eles) {
      elements -= ele
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}


class LinkedHMapContainerKVJ[A, B](var elements: JLinkedHashMap[A, B] = new JLinkedHashMap[A, B]()) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != null)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(eles: Seq[A]): ContainerKV[A, B] = {
    for (ele <- eles) {
      elements.remove(ele)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new JLinkedHashMap[A, B](Math.ceil(capacity / 0.75).toInt)
    this
  }

  override def getUnderlyingStorage() = elements
}

// mutable.WeakHashMap wraps JWeakHashMap
class WeakHMapContainerKVJ[A, B](var elements: JWeakHashMap[A, B] = new JWeakHashMap[A, B]()) extends ContainerKV[A, B] {

  override def existsBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[A]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != null)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, B)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(eles: Seq[A]): ContainerKV[A, B] = {
    for (ele <- eles) {
      elements.remove(ele)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new JWeakHashMap[A, B](Math.ceil(capacity / 0.75).toInt)
    this
  }

  override def getUnderlyingStorage() = elements
}