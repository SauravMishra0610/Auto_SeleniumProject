package com.base;

public abstract class BasePage extends Base {
    /*
    Java Generic methods and generic classes enable programmers to specify either:
    - a set of related types    with a single class declaration
    - a set of related methods  with a single method declaration
    Generics also provide compile-time type safety that allows programmers to catch invalid types at compile time.
    */
    public <ObjectPage extends BasePage> ObjectPage As(Class<ObjectPage> pageInstance) {
        try {
            return (ObjectPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
