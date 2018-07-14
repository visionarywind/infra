package com.wind.practice

////////////////////////////////////////////////////////////////////////////////////////////////////
// 用作接口
abstract class Animal {
  def speak
}

trait WaggingTail {
  def startTail { println("tail started") }
  def stopTail { println("tail stopped") }
}

trait FourLeggedAnimal {
  def walk
  def run
}

class Dogg extends Animal with WaggingTail with FourLeggedAnimal {
  def speak { println("Name is a dog") }
  def walk { println("Dog is walking") }
  def run { println("Dog is running") }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
// 使用特质中的抽象字段和实际字段
trait PizzaTrait {
  var numToppings: Int    //abstract
  var size = 14           //concrete
  val maxNumToppings = 10 //concrete
}

class Pizza extends PizzaTrait {
  var numToppings: Int = 0                //override is not needed
  size = 16                               //override and var is not needed
  override val maxNumToppings: Int = 20   //override and val is needed
}
////////////////////////////////////////////////////////////////////////////////////////////////////
// 当做抽象类
trait Pet {
  def speak { println("Yo") }
  def comeToMaster
}

class Dog extends Pet {
  def comeToMaster { println("I am comming") }
}

class Cat extends Pet {
  override def speak { println("I am a cat") }
  def comeToMaster { println("I will not come") }
}

abstract class FlyingPet extends Pet {  // 没有实现comeToMaster，需要声明为abstract
    def fly{ println("I am flying") }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
// 混入特质
trait Tail {
  def wagTail { println("tail is wagging") }
  def stopTail { println("tail is stopped") }
}

abstract class NamedPet(var name: String) {
  def speak
  def ownerIsHome { println("excited") }
  def jumpForJoy{ println("jumping for joy") }
}

class NamedDog(name: String) extends NamedPet(name) with Tail {
  def speak {println("woof")}

  override def ownerIsHome {
    wagTail
    speak
  }
}

///////////////////////////////////////////////////////////////////////////////
// 通过集成限制特质的使用范围
// trait [TraitName] extends [SuperThing]，使用场景少，不展开


///////////////////////////////////////////////////////////////////////////////
// 限制特质只可用于指定类型的子类
// trait 开头加上 this: BaseType => declaration
// scala self type : 任何具体类混入特质，必须保证他的类型和特质的self type一致
class Starship
trait StarFleetWarpCore {
  this: Starship =>
}
class EnterpriseImpl extends Starship with StarFleetWarpCore

///////////////////////////////////////////////////////////////////////////////
// 保证特质只能被添加到只有一个特定方法的类型 => 结构化类型
// self type变体，声明必须实现指定的方法
trait WarpCore {
  this: {
    def ejectWarpCore(passwd: String): Boolean
    def startWarpCore: Unit
  } =>
}

class Enterprise extends Starship with WarpCore {
  def ejectWarpCore(passwd: String): Boolean = {
    true
  }
  def startWarpCore: Unit = {
    println("core started")
  }
}

///////////////////////////////////////////////////////////////////////////////
// 为对象实例添加特质
trait Debugger {
  def log(message: String): Unit = {
    //
  }
}
class Child
object ScalaTrait {
  def createProblemChild = { val problemChild = new Child with Debugger }
}

///////////////////////////////////////////////////////////////////////////////
// 像特质一样继承java接口，没啥展开的