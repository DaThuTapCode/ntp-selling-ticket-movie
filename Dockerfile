# Sử dụng một image Java base
FROM openjdk:17-jdk-slim

# Tạo thư mục cho ứng dụng
WORKDIR /app

# Sao chép file JAR vào thư mục làm việc
COPY target/ticket-movie-1.0.jar app.jar

# Chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]
