package day22;

/**
 * 密封父类：只允许 Circle、Rectangle、Square 继承。
 */
public sealed interface Shape permits Circle, Rectangle, Square { }