# Prolog in Java - preduce

Prolog mechanisms combined in java library.

## Quick start

Options of quick start are available
  1. [Download tar archive](http://archive.org)
  1. Clone the repo

## Description

Description of Prolog in Java goes here

## Example

```java
    Prolog<String> p = new Prolog<String>();

    p.add(["Member",["A","B"],"A"]);
    p.add(["Member",["A","B"],"C"]).impl(["Member", "B","C"]);

    Anwser<String> ans = p.ask(["Member", [1,2,3,4,5],"X"]);

    while(ans.hasNext()) {
      System.out.print(ans.next());
      System.out.print(", ");
    }
```

Will resut

`1, 2, 3, 4, 5, `

## Installation

## Authors
Authors here

## License
License here
