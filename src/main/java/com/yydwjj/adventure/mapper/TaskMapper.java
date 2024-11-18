package com.yydwjj.adventure.mapper;

import com.yydwjj.adventure.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TaskMapper {


    Task getTaskById(int id);

    @Select("select * from adventure.task order by task_id desc ")
    List<Task> getAllTasks();

    @Update("insert adventure.task(adventure.task.task_name, adventure.task.publisher_id, adventure.task.task_level_id, " +
            "adventure.task.task_category_id, adventure.task.registration_start, adventure.task.registration_end, " +
            "adventure.task.task_start,adventure.task.task_end, adventure.task.participant_limit," +
            "adventure.task.location, adventure.task.created_at," +
            " adventure.task.updated_at, adventure.task.deleted_at, adventure.task.is_exist, adventure.task.task_info)" +
            "values(#{taskName},#{publisherId},#{taskLevelId},#{taskCategoryId},#{registrationStart},#{registrationEnd}," +
            "#{taskStart},#{taskEnd},#{participantLimit},#{location},#{createdAt},#{updatedAt},#{deletedAt},#{isExist},#{taskInfo})")
    int addTask(Task task);

    @Select("select * from adventure.task where task_category_id = #{categoryId} order by task_id desc ")
    List<Task> getTasksByCategoryId(int categoryId);

    @Select("select * from adventure.task where task_level_id = #{levelId} order by task_id desc ")
    List<Task> getTasksByLevelId(int levelId);

    /**
     * 在任务名称和任务介绍中模糊查询
     * @param keyword 查询关键字
     * @return 任务列表
     */
    @Select("select * from adventure.task where task_name like CONCAT('%', #{keyword}, '%') or task_info like CONCAT('%', #{keyword}, '%') order by task_id desc ")
    List<Task> findTask(String keyword);
}
