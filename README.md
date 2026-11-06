# JVM 学习笔记

> 从 Java 基础语法一路学到 JVM 底层原理与现代 Java 特性，每一天都用「最小可运行 Demo」把一个知识点讲透。

这是我学习 JVM / Java 底层的过程记录。仓库按 `dayXX` 组织，每个目录对应一个知识点，代码里配了大量中文注释，配合 `javap -c` 反编译可以直观看到字节码背后的真相。

---

## 📚 学习路线总览

```
Java 基础语法 ──► 面向对象 ──► JVM 底层原理 ──► 现代 Java 特性
   (day01~04)     (day05~10)     (day08~14)        (day15~22)
```

| 阶段 | 目录 | 核心内容 |
| ---- | ---- | -------- |
| **基础语法** | `day01` ~ `day04` | 访问修饰符、局部变量初始化、复合赋值运算符的字节码差异 |
| **面向对象** | `day05` ~ `day10` | 数组、引用传递、静态/实例方法、接口多态、内部类、参数传递 |
| **JVM 底层** | `day08` ~ `day14` | String 常量池与 GC、装箱缓存、泛型擦除、异常机制、HashMap |
| **现代 Java** | `day15` ~ `day22` | Lambda、Stream、文本块、var、switch、record、instanceof、sealed |

---

## 🗂 目录结构（知识点详解）

### 🟢 第一阶段：Java 基础语法

| 目录 | 主题 | 知识点 | 关键文件 |
| ---- | ---- | ------ | -------- |
| `day01` | 访问修饰符 | `Modifier` 关键字对应的底层数字标识 | `demo01.java` |
| `day02` | 局部变量 | 变量初始化、作用域、静态/成员变量区别 | `demo01~05.java` |
| `day03` | 类与成员变量 | 成员变量的默认值、对象初始化 | `Test.java` |
| `day04` | 复合赋值运算符 | `b += 1` 与 `b = b + 1` 的字节码差异（隐式强转） | `Demo01.java` |

### 🔵 第二阶段：面向对象

| 目录 | 主题 | 知识点 | 关键文件 |
| ---- | ---- | ------ | -------- |
| `day05` | 数组与引用传递 | 数组是对象、地址共享导致「改一处处处变」 | `ArrayTest.java`、`BytecodeDemo.java` |
| `day06` | 静态 vs 实例 | 静态方法类加载即用、实例方法必须先有对象 | `Demo01.java`、`StringUtils.java` |
| `day07` | 接口与多态 | 接口引用指向不同实现类，同一引用不同行为 | `Payment.java`、`Main.java` |
| `day09` | 内部类 | 成员/静态/局部/匿名四种内部类 | `Demo1~4.java` |
| `day10` | 方法参数传递 | 基本类型传副本、引用类型传地址、String/包装类不可变 | `Demo01.java`、`SpecialDemo1~5.java` |

### 🟡 第三阶段：JVM 底层原理

| 目录 | 主题 | 知识点 | 关键文件 |
| ---- | ---- | ------ | -------- |
| `day08` | String 五大禁区 | 循环拼接、动态 `intern()`、`substring` 内存泄漏、`==` 比较、字符集错误 | `Zone1~5.java` |
| `day11` | 装箱拆箱 | `valueOf`/`intValue` 语法糖、`Integer` 缓存池 `-128~127`、反射破坏缓存 | `Demo01~08.java` |
| `day12` | 泛型与类型擦除 | 擦除后同 Class、桥接方法、`checkcast` 插入时机 | `ErasureDemo.java`、`BridgeDemo.java` |
| `day13` | 异常机制 | `finally` 覆盖 return、栈展开、`fillInStackTrace` 性能优化 | `Demo01~04.java` |
| `day14` | HashMap | 增删改查、`getOrDefault`、遍历方式 | `HashMapDemo.java` |

### 🟣 第四阶段：现代 Java 特性（Java 10+）

| 目录 | 主题 | 知识点 | 关键文件 |
| ---- | ---- | ------ | -------- |
| `day15` | Lambda 表达式 | 函数式接口、方法引用、`Predicate` 组合 | `Demo1~3.java` |
| `day16` | Stream 流 | 中间/终端操作、`collect`、分组、并行流 | `Demo01~03.java`、`User.java` |
| `day17` | 文本块 Text Blocks | 三引号语法、`formatted` 格式化 | `Demo1~4.java` |
| `day18` | `var` 类型推断 | 局部变量推断、匿名类特有方法、`var` 的边界 | `Demo1~6.java` |
| `day19` | `switch` 表达式 | 箭头语法、多值 case、返回值 | `Demo1~5.java` |
| `day20` | `record` 记录类 | 自动生成 `equals`/`hashCode`/`toString`、紧凑构造函数 | `Demo1~3.java` |
| `day21` | `instanceof` 模式匹配 | 模式变量、短路逻辑、泛型限制 | `Demo01~04.java` |
| `day22` | `sealed` 密封类 | 穷尽检查、`permits` 限制继承、无需 `default` | `SealedDemo.java`、`NoSealedDemo.java` |

---

## 🎯 学习亮点

每个知识点都采用了「**错误示例 → 正确示例**」或「**对比实验**」的方式，让结论自己浮出水面：

- **`day04`**：`b += 1` 能编译，`b = b + 1` 却报错 —— 背后是复合赋值运算符的隐式类型转换
- **`day05`**：通过 `arr[1]` 改对象，`arr[0]` 也跟着变 —— 数组存的是引用地址
- **`day08`**：循环里 `+=` 拼接字符串 vs `StringBuilder`，10 万次耗时天差地别
- **`day11`**：用反射篡改 `IntegerCache`，实现 `2 + 2 == 5` 的经典谜题
- **`day12`**：`List<String>` 和 `List<Integer>` 的 `getClass()` 居然相等 —— 泛型被擦除了
- **`day22`**：有 `sealed` 时编译器能检查穷尽性，没有 `sealed` 时 `default` 成了「静默吞 bug」的定时炸弹

---

## 🛠 环境要求

| 项目 | 版本 |
| ---- | ---- |
| JDK | 17+（`record`/`sealed` 需要 16/17，文本块需要 15） |
| 构建 | 无（纯 `javac` / IDEA） |

---

## 🚀 如何运行

```bash
# 编译（例如运行 day22 的 sealed 演示）
javac -d out src/day22/*.java

# 运行
java -cp out day22.SealedDemo

# 想看字节码（强烈推荐配合学习）
javap -c -p out/day22/SealedDemo.class
```

> 💡 建议在 IDEA 中打开，`day` 目录下每个文件都能单独运行。配合 `javap -c` 反编译，能直观看到语法糖背后的真实字节码。

---

## 📝 学习进度

- [x] 基础语法（标识符、循环、数组、运算符）
- [x] 面向对象（对象、方法、接口、内部类、参数传递）
- [x] JVM 底层（String、装箱缓存、泛型擦除、异常、HashMap）
- [x] 现代特性（Lambda、Stream、文本块、var、switch、record、instanceof、sealed）

> 持续更新中 —— 每个知识点独立一个 commit，方便回溯。
