package com.farid.MyBlog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT " +
            "B.id AS id, " +
            "B.title AS title, " +
            "B.discription AS discription, " +
            "U.name AS name, " +
            "B.img AS img, " +
            "U.img AS Uimg, " +
            "U.email AS email, " +
            "(SELECT COUNT(*) FROM UserLikedBlog ULB WHERE ULB.blogid = B.id) AS likes, " +
            "(SELECT COUNT(*) FROM UserSharedBlog USB WHERE USB.blogid = B.id) AS shares, " +
            "(SELECT COUNT(*) FROM UserCommentedBlog UCB WHERE UCB.blogid = B.id) AS comments " +
            "FROM blogs B " +
            "JOIN users U ON B.author_id = U.id", nativeQuery = true)
    List<Object[]> findAllfindallblogs();

    default List<BlogDTO> getAllBlogs() {
        return findAllfindallblogs().stream()
            .map(row -> new BlogDTO(
                ((Number) row[0]).longValue(), // id
                (String) row[1], // title
                (String) row[2], // content
                (String) row[3], // name
                (String) row[4], // img
                (String) row[5], // Uimg
                (String) row[6], // email
                ((Number) row[7]).intValue(), // likes
                ((Number) row[8]).intValue(), // shares
                ((Number) row[9]).intValue()  // comments
            ))
            .toList();
    }


    @Query(value = "SELECT " +
            "B.id AS id, " +
            "B.title AS title, " +
            "B.discription AS discription, " +
            "U.name AS name, " +
            "B.img AS img, " +
            "U.img AS Uimg, " +
            "U.email AS email, " +
            "(SELECT COUNT(*) FROM UserLikedBlog ULB WHERE ULB.blogid = B.id) AS likes, " +
            "(SELECT COUNT(*) FROM UserSharedBlog USB WHERE USB.blogid = B.id) AS shares, " +
            "(SELECT COUNT(*) FROM UserCommentedBlog UCB WHERE UCB.blogid = B.id) AS comments " +
            "FROM blogs B " +
            "JOIN users U ON B.author_id = U.id " +
            "WHERE B.title LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Object[]> searchblog(String search);

    default List<BlogDTO> searchBlogs(String search) {
        return searchblog(search).stream()
            .map(row -> new BlogDTO(
                ((Number) row[0]).longValue(), // id
                (String) row[1], // title
                (String) row[2], // content
                (String) row[3], // name
                (String) row[4], // img
                (String) row[5], // Uimg
                (String) row[6], // email
                ((Number) row[7]).intValue(), // likes
                ((Number) row[8]).intValue(), // shares
                ((Number) row[9]).intValue()  // comments
            ))
            .toList();
    }
    @Query(value = "SELECT " +
            "B.id AS id, " +
            "B.title AS title, " +
            "B.discription AS discription, " +
            "U.name AS name, " +
            "B.img AS img, " +
            "U.img AS Uimg, " +
            "U.email AS email, " +
            "(SELECT COUNT(*) FROM UserLikedBlog ULB WHERE ULB.blogid = B.id) AS likes, " +
            "(SELECT COUNT(*) FROM UserSharedBlog USB WHERE USB.blogid = B.id) AS shares, " +
            "(SELECT COUNT(*) FROM UserCommentedBlog UCB WHERE UCB.blogid = B.id) AS comments " +
            "FROM blogs B " +
            "JOIN users U ON B.author_id = U.id " +
            "WHERE B.category_id in (select id from categories where name = ?1 ) ", nativeQuery = true)
    List<Object[]> fetchCategoryBlogsByCategory(String category);

    default List<BlogDTO> fetchCategoryBlogs(String category) {
        return fetchCategoryBlogsByCategory(category).stream()
            .map(row -> new BlogDTO(
                ((Number) row[0]).longValue(), // id
                (String) row[1], // title
                (String) row[2], // content
                (String) row[3], // name
                (String) row[4], // img
                (String) row[5], // Uimg
                (String) row[6], // email
                ((Number) row[7]).intValue(), // likes
                ((Number) row[8]).intValue(), // shares
                ((Number) row[9]).intValue()  // comments
            ))
            .toList();
    }

    @Query(value = "SELECT C.coment, U.name, U.email, U.img FROM UserCommentedBlog C, users U WHERE C.blogId = ?1 AND C.userId = U.id", nativeQuery = true)
    List<Object[]> blogComment(String blogId);

    default List<CommentDTO> findCommentsBlogs(String ID) {
        return blogComment(ID).stream()
            .map(row -> new CommentDTO(
                (String) row[0], // comment
                (String) row[1], // user name
                (String) row[2], // user email
                (String) row[3]  // user image
            ))
            .toList();
    }
    @Query(value = "SELECT " +
    "B.id AS id, " +
    "B.title AS title, " +
    "B.discription AS discription, " +
    "U.name AS name, " +
    "B.img AS img, " +
    "U.img AS Uimg, " +
    "U.email AS email, " +
    "(SELECT COUNT(*) FROM UserLikedBlog ULB WHERE ULB.blogid = B.id) AS likes, " +
    "(SELECT COUNT(*) FROM UserSharedBlog USB WHERE USB.blogid = B.id) AS shares, " +
    "(SELECT COUNT(*) FROM UserCommentedBlog UCB WHERE UCB.blogid = B.id) AS comments " +
    "FROM blogs B " +
    "JOIN users U ON B.author_id = U.id " +
    "WHERE B.id = ?1 ", nativeQuery = true)
    Object fetchBlogById(int ID);

    default BlogDTO getBlogById(int ID) {
        Object[] row = (Object[]) fetchBlogById(ID);
        return new BlogDTO(
            ((Number) row[0]).longValue(), // id
            (String) row[1], // title
            (String) row[2], // discription
            (String) row[3], // name
            (String) row[4], // img
            (String) row[5], // Uimg
            (String) row[6], // email
            ((Number) row[7]).intValue(), // likes
            ((Number) row[8]).intValue(), // shares
            ((Number) row[9]).intValue()  // comments
        );
    }
}

