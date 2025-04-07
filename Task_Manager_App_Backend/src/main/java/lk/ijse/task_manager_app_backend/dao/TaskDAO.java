package lk.ijse.task_manager_app_backend.dao;

import lk.ijse.task_manager_app_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO extends JpaRepository<Task, Long> {
}
