package com.example.Assignment.entity;

import com.example.Assignment.commons.AbstractAuditionGuidKeyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "view_user")
public class ViewUser extends AbstractAuditionGuidKeyEntity {

    @ManyToOne
    @JoinColumn(name = "viewed_User")
    private User viewedUser;

    @ManyToOne
    @JoinColumn(name = "viewer_User")
    private User viewerUser;

    @Column(name = "viewed_date")
    private Date viewedDate;




}
