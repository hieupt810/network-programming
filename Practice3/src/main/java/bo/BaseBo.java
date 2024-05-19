package bo;

import java.util.List;

public interface BaseBo<T, ID> {
    T add(T data);

    T edit(T data, ID id);

    void delete(ID id);

    T getById(ID id);

    List<T> getAll();
}
