package com.cse.Library_Management_System;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Lob;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="students")
//public class Students {
//	@Id
//    @Column(name="student_email")
//    private String studentEmail;
//
//    @Column(name="student_id")
//    private String studentId;
//
//    @Column(name="student_name")
//    private String studentName;
//
//    @Column(name="student_branch")
//    private String studentBranch;
//
//    @Lob // Store large objects like images
//    @Column(name="profile_picture")
//    private byte[] profilePicture;
//	
// // Getters and setters
//    public byte[] getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(byte[] profilePicture) {
//        this.profilePicture = profilePicture;
//    }
//    
//    // Other getters and setters...
//	private String studentPassword;
//	public String getStudentId() {
//		return studentId;
//	}
//	public void setStudentId(String studentId) {
//		this.studentId = studentId;
//	}
//	public String getStudentName() {
//		return studentName;
//	}
//	public void setStudentName(String studentName) {
//		this.studentName = studentName;
//	}
//	public String getStudentBranch() {
//		return studentBranch;
//	}
//	public void setStudentBranch(String studentBranch) {
//		this.studentBranch = studentBranch;
//	}
//	public String getStudentEmail() {
//		return studentEmail;
//	}
//	public void setStudentEmail(String studentEmail) {
//		this.studentEmail = studentEmail;
//	}
//	public String getStudentPassword() {
//		return studentPassword;
//	}
//	public void setStudentPassword(String studentPassword) {
//		this.studentPassword = studentPassword;
//	}
//	@Override
//	public String toString() {
//		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", studentBranch=" + studentBranch
//				+ ", studentEmail=" + studentEmail + ", studentPassword=" + studentPassword + "]";
//	}
//	
//}





@Entity
public class Students {
    @Id
    private String studentId;
    private String studentName;
    private String studentBranch;
    private String studentEmail;
    private String studentPassword;

    @Lob
    private byte[] profilePicture; // Use @Lob for large objects like byte arrays

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentBranch() {
        return studentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        this.studentBranch = studentBranch;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

	public void setProfilePicture(String string) {
		// TODO Auto-generated method stub
		
	}
}
