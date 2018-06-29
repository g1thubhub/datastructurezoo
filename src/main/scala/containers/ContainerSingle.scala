package containers

trait ContainerSingle[A] {

  def accessBatch(pos: Seq[Int]): ContainerSingle[A]

  def searchBatch(items: Seq[A]): Int

  def insertBatch(ele: Seq[A]): ContainerSingle[A]

  def deleteBatch(ele: Seq[A]): ContainerSingle[A]

  val hasCapacity: Boolean

  def initializeWithCapacity(capacity: Int): ContainerSingle[A]

  def getUnderlyingStorage(): Object // for convenient memory measurements
}


object ContainerSingle {

  val linearStructures = List[String](
    "ListContainer", "ArrayBufferContainer", "ListBufferContainer", "QueueContainer", "QueueMContainer", "VectorContainer",
    "HashSetContainer", "HashSetMContainer", "TreeSetContainer", "TreeSetMContainer", "LinkedHashSetMContainer", "PriorityQueueMContainer",
    "ArrayListJContainer", "DoublyLLJContainer", "StackJContainer", "VectorJContainer", "QueueJContainer", "HashSetJContainer",
    "TreeSetJContainer", "LinkedHashSetJContainer", "SkipListJContainer", "PriorityQueueJContainer")


  def getEmptyArray[A](array: Array[A], container: String, clazz: Class[A]) = container match {
    case "BasicArrayContainer" => new BasicArrayContainer(array)
  }

  def getEmptyJDKContainer[A](container: String, clazz: Class[A])(implicit ordering: Ordering[A]): ContainerSingle[A] = container match {

    case "ListContainer" => new ListContainer[A]()
    case "ArrayBufferContainer" => new ArrayBufferContainer[A]()
    case "ListBufferContainer" => new ListBufferContainer[A]()
    case "QueueContainer" => new QueueContainer[A]()
    case "QueueMContainer" => new QueueMContainer[A]()
    case "VectorContainer" => new VectorContainer[A]()
    case "HashSetContainer" => new HashSetContainer[A]()
    case "HashSetMContainer" => new HashSetMContainer[A]()
    case "TreeSetContainer" => new TreeSetContainer[A]()
    case "TreeSetMContainer" => new TreeSetMContainer[A]()
    case "LinkedHashSetMContainer" => new LinkedHashSetMContainer[A]()
    case "PriorityQueueMContainer" => new PriorityQueueMContainer[A]()

    case "ArrayListJContainer" => new ArrayListJContainer[A]()
    case "DoublyLLJContainer" => new DoublyLLJContainer[A]()
    case "StackJContainer" => new StackJContainer[A]()
    //    case "QueueJContainer" => new QueueJContainer[A]()  // Delayed
    case "VectorJContainer" => new VectorJContainer[A]()
    case "HashSetJContainer" => new HashSetJContainer[A]()
    case "TreeSetJContainer" => new TreeSetJContainer[A]()
    case "LinkedHashSetJContainer" => new LinkedHashSetJContainer[A]()
    case "SkipListJContainer" => new SkipListJContainer[A]()
    case "PriorityQueueJContainer" => new PriorityQueueJContainer[A]()

  }


  val linearStructures3rdInt = List[String](
    "ArrayListHppcInt", "HashSetHppcInt",
    "HashSetKolobokeInt", // add operation not supported
    "HashSetKolobokeIntM", "ArrayListFastutilInt", "HashSetFastutilInt", "ArrayListEclipseInt",
    "SetEclipseInt", // very slow to build incrementally
    "ArrayListEclipseIntM", "SetEclipseIntM")


  def getEmpty3rdIntContainer(container: String): ContainerSingle[Int] = container match {
    case "ArrayListHppcInt" => new ArrayListHppcInt()
    case "ArrayListFastutilInt" => new ArrayListFastutilInt()
    case "ArrayListEclipseInt" => new ArrayListEclipseInt()
    case "ArrayListEclipseIntM" => new ArrayListEclipseIntM()
    case "HashSetHppcInt" => new HashSetHppcInt()
    case "HashSetKolobokeInt" => new HashSetKolobokeInt()
    case "HashSetKolobokeIntM" => new HashSetKolobokeIntM()
    case "HashSetFastutilInt" => new HashSetFastutilInt()
    case "SetEclipseInt" => new SetEclipseInt()
    case "SetEclipseIntM" => new SetEclipseIntM()
  }


  val linearStructures3rdObj = List[String]("ArrayListHppc", "HashSetHppc", "ArrayListFastUtil", "HashSetFastUtil",
    "HashSetKoloboke", "ArrayListEclipseM", "SetEclipse", "ArrayListEclipse", "SetEclipseM")


  def getEmpty3rdContainer[A](container: String, clazz: Class[A]) = container match {
    case "ArrayListHppc" => new ArrayListHppc[A]()
    case "HashSetHppc" => new HashSetHppc[A]()
    case "ArrayListFastUtil" => new ArrayListFastUtil[A]()
    case "HashSetFastUtil" => new HashSetFastUtil[A]()
    case "HashSetKoloboke" => new HashSetKoloboke[A]()
    case "ArrayListEclipse" => new ArrayListEclipse[A]()
    case "ArrayListEclipseM" => new ArrayListEclipseM[A]()
    case "SetEclipse" => new SetEclipse[A]()
    case "SetEclipseM" => new SetEclipseM[A]()
  }

}
