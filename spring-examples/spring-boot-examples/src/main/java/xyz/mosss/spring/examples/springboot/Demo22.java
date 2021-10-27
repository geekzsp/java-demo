package xyz.mosss.spring.examples.springboot;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.ByteArrayInputStream;

public class Demo22 {
    public static void main(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-ap-south-1.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String AccessKeyId = "STS.NUJULqJNtoCpEAScxCNNukjeR";
        String accessKeySecret = "36KKsU1q8xYRtLH6KkxnVQr66LDVAxgsba5bhJv2AbcF";
        String securityToken = "CAIS/QJ1q6Ft5B2yfSjIr5b/HvbFp5FV2IGbR2fih3gWQsFZhK/OsDz2IHtNf3NqB+EesP0/lG1Q6voTlrUpE8UdHRKeN5IttM8OqFOtPdGQ5PGeteRc0MX/Qexey9Q9mp28Wf7waf+AUCjECTmd5PYao9bTcTGlQCbqU/mggoJmadI6RxSxaSE8av5dOgplrr19Vx7WLu3/CgP2pWDSAUF0wB0e71ly8qOi2MaRxwPDhVnhsI8vqp/2P4KvYrtnXrV2WMzn2/dtJOiTknxb7l1A9aF/lr0D8zbBt8uMKF1Q7hOaCPLd+dAoMAJievJiQfYc8qKmzKAi4bWKx4ipkEcSAMoNC3yHHNrngqm5EeiyZNEibuS5aTaf2dXKPJjzuhk1QwpGZV4SKoF/cyMvUEx1EWqDEML9pgCaMjXEYrOezaQ73aByy1jV5teQLzCNOe7CiH1CYMFtNx1xZ05LhTC9I7V6SSVpNmhbPPOeRJ5zaRlboObwpwrCrbuAf520Hp8agAFv5zHREI+m1oBkdU59HV+VHoHdDNEHDIUEdIBHny0Pr1k5QohTgwuqV/KDOpGrggdt35stgZuvXeYr4MGFIyyZL7oP1kUX9F+Z/Jp/+6HmJu4b/0vCJWVkrvb0Sntm03jU46v51OXiPx54+JEwK+p6jtqvI/DO6cFBKCx8IRnqJw==";

// 用户拿到STS临时凭证后，通过其中的安全令牌（SecurityToken）和临时访问密钥（AccessKeyId和AccessKeySecret）生成OSSClient。
// 创建OSSClient实例。注意，这里使用到了上一步生成的临时访问凭证（STS访问凭证）。
        OSSClient ossClient = new OSSClient(endpoint, AccessKeyId, accessKeySecret, securityToken);

// OSS操作。
// 创建PutObjectRequest对象。
        String content = "Hello OSS";
// <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest("cashmama-pro", "binaryClientSpace/test202006221523118d6397UC000002/a", new ByteArrayInputStream(content.getBytes()));

// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);

// 上传字符串。
        ossClient.putObject(putObjectRequest);
// 关闭OSSClient。
        ossClient.shutdown();
    }
}