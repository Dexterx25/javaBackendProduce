package com.alibou.security.messages;


public interface ErrorMessages {
     String blankError = "field value shouldn't blank";
     String characterNotAllow = "field characters not allow";
     String descriptionLength = "field could be more than 2 characters and less 250";
     String summaryLength = "field could be more than 2 characters and less 150";
     String userNameNotFound = "User not found with this userName";
}
