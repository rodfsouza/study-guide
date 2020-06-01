

import java.util.Hashtable;

/**
 * Created by rodsou on 11/2/16.
 */
public class SocialNetworking implements Networking {
  public Hashtable<Integer, User> users;

  public SocialNetworking(User user) {
    this.users = new Hashtable<Integer, User>();
    users.put(user.id, user);
  }

  @Override
  public boolean hasLikeFrom(User user) {
    if (users.containsKey(user.getId())) {
      return true;
    }
    return false;
  }
}

class User {
  Integer id;
  String name;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    return ((o instanceof User) && (((User) o).getId() == this.id) &&
        (((User) o).getName().equals(this.name)));
  }

  @Override
  public int hashCode() {
    int result = 0;
    result = (int) (id / 31);
    return result;
  }
}
