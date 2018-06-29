package containers

import com.carrotsearch.hppc.{IntHashSet, IntIntHashMap, ObjectArrayList, ObjectFloatHashMap, ObjectHashSet, IntArrayList => IntArrayListHPC}
import com.koloboke.collect.map.ObjFloatMap
import com.koloboke.collect.map.hash.{HashIntIntMap, HashIntIntMaps, HashObjFloatMaps}
import com.koloboke.collect.set.hash.{HashIntSet, HashIntSets, HashObjSet, HashObjSets}
import it.unimi.dsi.fastutil.ints.{Int2IntOpenHashMap, IntArrayList, IntOpenHashSet}
import it.unimi.dsi.fastutil.objects.{Object2FloatOpenHashMap, ObjectOpenHashSet, ObjectArrayList => FastUtilArrayList}
import org.eclipse.collections.api.list.primitive.{ImmutableIntList, MutableIntList}
import org.eclipse.collections.api.list.{ImmutableList, MutableList}
import org.eclipse.collections.api.map.primitive.{MutableIntIntMap, MutableObjectFloatMap}
import org.eclipse.collections.api.set.primitive.{ImmutableIntSet, MutableIntSet}
import org.eclipse.collections.api.set.{ImmutableSet, MutableSet}
import org.eclipse.collections.impl.factory.primitive.{IntIntMaps, IntLists, IntSets, ObjectFloatMaps}
import org.eclipse.collections.impl.factory.{Lists, Sets}

class Container3rdParty {}


class ArrayListHppcInt(var elements: IntArrayListHPC = new IntArrayListHPC()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.get(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.removeFirst(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new IntArrayListHPC(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}

class ArrayListHppc[A](var elements: ObjectArrayList[A] = new ObjectArrayList[A]()) extends ContainerSingle[A] {

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
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.removeFirst(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new ObjectArrayList(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class HashSetHppc[A](var elements: ObjectHashSet[A] = new ObjectHashSet[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new ObjectHashSet(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class HashSetHppcInt(var elements: IntHashSet = new IntHashSet()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new IntHashSet(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class ArrayListFastutilInt(var elements: IntArrayList = new IntArrayList()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.getInt(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.removeInt(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new IntArrayList(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class ArrayListFastUtil[A](var elements: FastUtilArrayList[A] = new FastUtilArrayList[A]()) extends ContainerSingle[A] {

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
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new FastUtilArrayList[A](capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class HashSetKolobokeInt(var elements: HashIntSet = HashIntSets.newImmutableSet(Array.empty[Int])) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


class HashSetKoloboke[A](var elements: HashObjSet[A] = HashObjSets.newMutableSet[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = HashObjSets.newMutableSet[A](capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class HashSetKolobokeIntM(var elements: HashIntSet = HashIntSets.newMutableSet()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[Int]): Int = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = HashIntSets.newMutableSet(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class HashSetFastUtil[A](var elements: ObjectOpenHashSet[A] = new ObjectOpenHashSet[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]): Int = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new ObjectOpenHashSet[A](capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class HashSetFastutilInt(var elements: IntOpenHashSet = new IntOpenHashSet()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[Int]): Int = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new IntOpenHashSet(capacity)
    this
  }

  override def getUnderlyingStorage() = elements

}


class ArrayListEclipseInt(var elements: ImmutableIntList = IntLists.immutable.empty()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.get(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements = elements.newWith(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements = elements.newWithout(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}

class ArrayListEclipseIntM(var elements: MutableIntList = IntLists.mutable.empty()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = {
    for (p <- pos) {
      if (elements.get(p) == null)
        throw new NoSuchElementException("Position/Element should have been present")
    }
    this
  }

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this


  override def getUnderlyingStorage() = elements

  def toImmutable = elements.toImmutable

}


class ArrayListEclipse[A](var elements: ImmutableList[A] = Lists.immutable.empty[A]()) extends ContainerSingle[A] {

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
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements = elements.newWith(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements = elements.newWithout(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}

class ArrayListEclipseM[A](val elements: MutableList[A] = Lists.mutable.empty[A]()) extends ContainerSingle[A] {

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
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override def getUnderlyingStorage() = elements

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  def toImmutable = elements.toImmutable

}


class SetEclipseInt(var elements: ImmutableIntSet = IntSets.immutable.empty()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements = elements.newWith(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements = elements.newWithout(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


class SetEclipseIntM(val elements: MutableIntSet = IntSets.mutable.empty()) extends ContainerSingle[Int] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[Int]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[Int]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

  def toImmutable = elements.toImmutable


}


class SetEclipse[A](var elements: ImmutableSet[A] = Sets.immutable.empty[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements = elements.newWith(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements = elements.newWithout(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

}


class SetEclipseM[A](val elements: MutableSet[A] = Sets.mutable.empty[A]()) extends ContainerSingle[A] {

  override def accessBatch(pos: Seq[Int]) = throw new UnsupportedOperationException("")

  override def searchBatch(items: Seq[A]) = {
    var sum = 0
    for (item <- items) {
      if (elements.contains(item))
        sum += 1
    }
    sum
  }

  override def insertBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.add(item)
    }
    this
  }

  override def deleteBatch(items: Seq[A]) = {
    for (item <- items) {
      elements.remove(item)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements

  def toImmutable = elements.toImmutable


}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class HashHppcContainerII(var elements: IntIntHashMap = new IntIntHashMap()) extends ContainerKV[Int, Int] {

  override def existsBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != 0)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(Int, Int)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[Int]) = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new IntIntHashMap(capacity)
    this
  }

  override def getUnderlyingStorage() = elements
}


class HashHppcContainerOF[A](var elements: ObjectFloatHashMap[A] = new ObjectFloatHashMap[A]()) extends ContainerKV[A, Float] {

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
      if (elements.get(key) != 0.0)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, Float)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[A]) = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new ObjectFloatHashMap[A](capacity)
    this
  }

  override def getUnderlyingStorage() = elements
}


class HashFastutilContainerII(var elements: Int2IntOpenHashMap = new Int2IntOpenHashMap()) extends ContainerKV[Int, Int] {

  override def existsBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != 0)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(Int, Int)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[Int]) = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new Int2IntOpenHashMap(capacity)
    this
  }

  override def getUnderlyingStorage() = elements
}


class HashFastutilContainerOF[A](var elements: Object2FloatOpenHashMap[A] = new Object2FloatOpenHashMap[A]()) extends ContainerKV[A, Float] {

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
      if (elements.getFloat(key) != 0.0F)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, Float)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[A]) = {
    for (key <- keys) {
      elements.removeFloat(key)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = new Object2FloatOpenHashMap[A](capacity)
    this
  }

  override def getUnderlyingStorage() = elements
}


class HashKolobokeContainerII(var elements: HashIntIntMap = HashIntIntMaps.newMutableMap()) extends ContainerKV[Int, Int] {

  override def existsBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != 0)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(Int, Int)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[Int]) = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = HashIntIntMaps.newMutableMap(capacity)
    this
  }

  override def getUnderlyingStorage() = elements
}


class HashKolobokeContainerOF[A](var elements: ObjFloatMap[A] = HashObjFloatMaps.newMutableMap[A]()) extends ContainerKV[A, Float] {

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
      if (elements.getFloat(key) != 0.0F)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, Float)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[A]) = {
    for (key <- keys) {
      elements.removeAsFloat(key)
    }
    this
  }

  override val hasCapacity = true

  override def initializeWithCapacity(capacity: Int) = {
    elements = HashObjFloatMaps.newMutableMap[A](capacity)
    this
  }

  override def getUnderlyingStorage() = elements
}


class HashEclipseContainerII(var elements: MutableIntIntMap = IntIntMaps.mutable.empty()) extends ContainerKV[Int, Int] {

  override def existsBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.containsKey(key))
        found += 1
    }
    found
  }


  override def retrieveBatch(keys: Seq[Int]) = {
    var found = 0
    for (key <- keys) {
      if (elements.get(key) != 0)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(Int, Int)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[Int]) = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}


class HashEclipseContainerOF[A](var elements: MutableObjectFloatMap[A] = ObjectFloatMaps.mutable.empty[A]()) extends ContainerKV[A, Float] {

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
      if (elements.get(key) != 0.0F)
        found += 1
    }
    found
  }

  override def insertBatch(eles: Seq[(A, Float)]) = {
    for (ele <- eles) {
      elements.put(ele._1, ele._2)
    }
    this
  }

  override def deleteBatch(keys: Seq[A]) = {
    for (key <- keys) {
      elements.remove(key)
    }
    this
  }

  override val hasCapacity = false

  override def initializeWithCapacity(capacity: Int) = this

  override def getUnderlyingStorage() = elements
}
