package common;

import enums.Messenger;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T>{
    public abstract Messenger save(T t);
    public abstract List<T> findAll();
    public abstract Optional<T> findById(Long id);//머신에서 정한  id
    public abstract String count();
    public abstract Optional<T> getOne(String id);//가입자가 적은 id
    public abstract String delete(T t);
    public abstract Boolean existsById(Long id);
}
