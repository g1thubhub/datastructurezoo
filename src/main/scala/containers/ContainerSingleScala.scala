package containers

import scala.collection.immutable.Queue
import scala.collection.{immutable, mutable}

class BasicArrayContainer[A](elements: Array[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(ele: Seq[A]): ContainerSingle[A] = throw new UnsupportedOperationException("This op is not supported by this data structure")

  override def deleteBatch(ele: Seq[A]): ContainerSingle[A] = throw new UnsupportedOperationException("This op is not supported by this data structure")

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements


}


class ListContainer[A](var elements: List[A] = List.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = item :: elements
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements.filter(_ == item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this


  override def getUnderlyingStorage() = elements

}


class ArrayBufferContainer[A](var elements: mutable.ArrayBuffer[A] = mutable.ArrayBuffer.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements += item
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements -= item
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new mutable.ArrayBuffer(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}

class ListBufferContainer[A](elements: mutable.ListBuffer[A] = mutable.ListBuffer.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements += item
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements -= item
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this


  override def getUnderlyingStorage() = elements

}


class QueueContainer[A](var elements: Queue[A] = Queue.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements.enqueue(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (_ <- items) {
      elements = elements.dequeue._2
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}

class QueueMContainer[A](elements: mutable.Queue[A] = mutable.Queue.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements += item
    }
    this
  }


  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (_ <- items) {
      elements.dequeue()
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this


  override def getUnderlyingStorage() = elements

}


class VectorContainer[A](var elements: Vector[A] = Vector.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]): Int = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = item +: elements
    }
    this
  }


  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements.filter(_ == item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


//////////////////


class HashSetContainer[A](var elements: immutable.HashSet[A] = immutable.HashSet.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements + item
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements - item
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


class HashSetMContainer[A](var elements: mutable.HashSet[A] = mutable.HashSet.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements += item
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements -= item
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


class TreeSetContainer[A](implicit ordering: Ordering[A]) extends ContainerSingle[A] {
  var elements = immutable.TreeSet.empty[A]

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements + item
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements - item
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}

class TreeSetMContainer[A](implicit val ordering: Ordering[A]) extends ContainerSingle[A] {
  var elements = mutable.TreeSet.empty[A]

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]): Int = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements = elements += item
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements -= item
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


class LinkedHashSetMContainer[A](var elements: mutable.LinkedHashSet[A] = mutable.LinkedHashSet.empty[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


class PriorityQueueMContainer[A](implicit ordering: Ordering[A]) extends ContainerSingle[A] {
  var elements = mutable.PriorityQueue.empty[A](ordering)

  override def accessBatch(pos: Seq[Int]) = {
    for (_ <- pos) {
      if (elements.head == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.find(_ == item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements += item
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (_ <- items) {
      elements.dequeue()
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}