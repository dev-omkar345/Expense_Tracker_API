package com.example.Track_Api.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.catalina.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "et_users")
@Setter
@Getter
public class User implements UserDetails,UserIn
{	
    @Id
    @Column(name  = "user_id", nullable = false)
    private int user_id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name  = "last_name", unique = true, length = 100, nullable = false)
    private String last_name;

    @Column(name  = "email", nullable = false)
    private String email;
    
    @Column(name  = "password", nullable = false)
    private String password;
    
    @Transient
    @Nullable
    @JoinColumn(name = "category_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Category> listOfCategories = new HashSet<>();  //Using Set is recommended..                                                                                  
    
    @Transient
    @Nullable
	@JoinColumn(name = "transaction_id")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Transaction userTransaction;                                                                                                     
    
    @Nullable
	@Column(name = "totalexpense")
	private Double totalexpense;
    
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findsssByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}



	
	

}
