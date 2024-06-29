package study.data_jpa.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import study.data_jpa.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
