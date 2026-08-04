package com.samit.lld.solid.interfacesegregation.goodcode;

// Better approach following ISP
interface Printer {
  void print();
}

interface Scanner {
  void scan();
}

interface FaxMachine {
  void fax();
}

class BasicPrinter implements Printer {
  @Override
  public void print() {
    // Printing functionality
  }
}

class AllInOnePrinter implements Printer, Scanner, FaxMachine {
  @Override
  public void print() {
    // Printing functionality
  }
  @Override
  public void scan() {
    // Scanning functionality
  }
  @Override
  public void fax() {
    // Fax functionality
  }
}