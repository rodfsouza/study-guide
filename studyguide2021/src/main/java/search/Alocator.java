package search;

public interface Alocator {

  String allocate(String prefix);

  void deallocate(String name);
}
