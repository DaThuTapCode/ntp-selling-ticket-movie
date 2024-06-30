# Sử dụng image cơ sở mà có Java đã cài đặt
FROM openjdk:17

# Thư mục làm việc mặc định trong container
#WORKDIR /app

# Sao chép file JAR đã đóng gói vào container
ADD target/ticket-movie-1.0.war /app/ticket-movie-1.0.war
#COPY ./target/ticket-movie-1.0.war /app/ticket-movie-1.0.war

# Thiết lập biến môi trường cho MySQL
#ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/ntp_booking_movie
#ENV SPRING_DATASOURCE_USERNAME=root
#ENV SPRING_DATASOURCE_PASSWORD=130904

# Cổng mà ứng dụng Spring Boot lắng nghe
#EXPOSE 8080

# Lệnh để khởi động ứng dụng Spring Boot khi container được khởi chạy
ENTRYPOINT ["java", "-jar", "ticket-movie-1.0.war"]
