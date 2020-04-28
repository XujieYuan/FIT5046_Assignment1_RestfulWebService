/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoir;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yuanxujie
 */
@Entity
@Table(name = "MEMOIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memoir.findAll", query = "SELECT m FROM Memoir m")
    , @NamedQuery(name = "Memoir.findByMemoirid", query = "SELECT m FROM Memoir m WHERE m.memoirid = :memoirid")
    , @NamedQuery(name = "Memoir.findByMoviename", query = "SELECT m FROM Memoir m WHERE m.moviename = :moviename")
    , @NamedQuery(name = "Memoir.findByMoviereleasedate", query = "SELECT m FROM Memoir m WHERE m.moviereleasedate = :moviereleasedate")
    , @NamedQuery(name = "Memoir.findByWatchdate", query = "SELECT m FROM Memoir m WHERE m.watchdate = :watchdate")
    , @NamedQuery(name = "Memoir.findByComment", query = "SELECT m FROM Memoir m WHERE m.comment = :comment")
    , @NamedQuery(name = "Memoir.findByRatingscore", query = "SELECT m FROM Memoir m WHERE m.ratingscore = :ratingscore")
    , @NamedQuery(name = "Memoir.findByPid", query = "SELECT m FROM Memoir m WHERE m.pid = :pid")
    , @NamedQuery(name = "Memoir.findByCid", query = "SELECT m FROM Memoir m WHERE m.cid = :cid")
    , @NamedQuery(name = "Memoir.task3D_findMovieByCinemaname", query = "SELECT m FROM Memoir m WHERE m.cid.cinemaname = :cinemaname")})
public class Memoir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMOIRID")
    private Integer memoirid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MOVIENAME")
    private String moviename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIERELEASEDATE")
    @Temporal(TemporalType.DATE)
    private Date moviereleasedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WATCHDATE")
    @Temporal(TemporalType.DATE)
    private Date watchdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "COMMENT")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATINGSCORE")
    private int ratingscore;
    @JoinColumn(name = "CID", referencedColumnName = "CINEMAID")
    @ManyToOne(optional = false)
    private Cinema cid;
    @JoinColumn(name = "PID", referencedColumnName = "PERSONID")
    @ManyToOne(optional = false)
    private Person pid;

    public Memoir() {
    }

    public Memoir(Integer memoirid) {
        this.memoirid = memoirid;
    }

    public Memoir(Integer memoirid, String moviename, Date moviereleasedate, Date watchdate, String comment, int ratingscore) {
        this.memoirid = memoirid;
        this.moviename = moviename;
        this.moviereleasedate = moviereleasedate;
        this.watchdate = watchdate;
        this.comment = comment;
        this.ratingscore = ratingscore;
    }

    public Integer getMemoirid() {
        return memoirid;
    }

    public void setMemoirid(Integer memoirid) {
        this.memoirid = memoirid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public Date getMoviereleasedate() {
        return moviereleasedate;
    }

    public void setMoviereleasedate(Date moviereleasedate) {
        this.moviereleasedate = moviereleasedate;
    }

    public Date getWatchdate() {
        return watchdate;
    }

    public void setWatchdate(Date watchdate) {
        this.watchdate = watchdate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRatingscore() {
        return ratingscore;
    }

    public void setRatingscore(int ratingscore) {
        this.ratingscore = ratingscore;
    }

    public Cinema getCid() {
        return cid;
    }

    public void setCid(Cinema cid) {
        this.cid = cid;
    }

    public Person getPid() {
        return pid;
    }

    public void setPid(Person pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memoirid != null ? memoirid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memoir)) {
            return false;
        }
        Memoir other = (Memoir) object;
        if ((this.memoirid == null && other.memoirid != null) || (this.memoirid != null && !this.memoirid.equals(other.memoirid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "memoir.Memoir[ memoirid=" + memoirid + " ]";
    }

}
