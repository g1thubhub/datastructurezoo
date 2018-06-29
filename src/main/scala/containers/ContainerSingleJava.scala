package containers

import java.util.concurrent.{ConcurrentSkipListSet => JSkipList, DelayQueue => JDelayQueue}
import java.util.{PriorityQueue, ArrayList => JArrayList, HashSet => JHashSet, LinkedHashSet => JLinkedHashSet, LinkedList => JLinkedList, Stack => JStack, TreeSet => JTreeSet, Vector => JVector}


class ArrayListJContainer[A](var elements: JArrayList[A] = new JArrayList[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.get(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.indexOf(item)
      if (el > -1)
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

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new JArrayList[A](capacity)
    this
  }

  override def getUnderlyingStorage = elements

}


class DoublyLLJContainer[A](elements: JLinkedList[A] = new JLinkedList[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.get(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.indexOf(item)
      if (el > -1)
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

  override def getUnderlyingStorage = elements

}


class StackJContainer[A](var elements: JStack[A] = new JStack[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (_ <- pos) {
      if (elements.peek() == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]): Int = {
    var sum = 0
    for (item <- items) {
      val el = elements.search(item)
      if (el > -1)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements.push(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (_ <- items) {
      elements.pop()
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this


  override def getUnderlyingStorage = elements

}


class QueueJContainer[A <: java.util.concurrent.Delayed](elements: JDelayQueue[A] = new JDelayQueue[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.peek() == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

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

  override def getUnderlyingStorage = elements

}


class VectorJContainer[A](var elements: JVector[A] = new JVector[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.get(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.indexOf(item)
      if (el > -1)
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


  override def getUnderlyingStorage = elements

}


class HashSetJContainer[A](var elements: JHashSet[A] = new JHashSet[A]()) extends ContainerSingle[A] {

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

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new JHashSet[A](Math.ceil(capacity / 0.75).toInt)
    this
  }

  override def getUnderlyingStorage = elements

}


class TreeSetJContainer[A](var elements: JTreeSet[A] = new JTreeSet[A]()) extends ContainerSingle[A] {

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

  override def getUnderlyingStorage = elements

}


class LinkedHashSetJContainer[A](var elements: JLinkedHashSet[A] = new JLinkedHashSet[A]()) extends ContainerSingle[A] {

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

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new JLinkedHashSet[A](Math.ceil(capacity / 0.75).toInt)
    this
  }

  override def getUnderlyingStorage = elements

}


class SkipListJContainer[A](var elements: JSkipList[A] = new JSkipList[A]()) extends ContainerSingle[A] {

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

  override def getUnderlyingStorage = elements

}

class PriorityQueueJContainer[A](var elements: PriorityQueue[A] = new PriorityQueue[A]) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = {
    for (_ <- pos) {
      if (elements.peek() == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      val el = elements.contains(item)
      if (el != None)
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]): ContainerSingle[A] = {
    for (item <- items) {
      elements.offer(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]): ContainerSingle[A] = {
    for (_ <- items) {
      elements.poll()
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    if (capacity > 0) // 0 throws exception
      elements = new PriorityQueue[A](capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}
