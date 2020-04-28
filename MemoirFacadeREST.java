/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoir.service;

//import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import memoir.Memoir;

/**
 *
 * @author yuanxujie
 */
@Stateless
@Path("memoir.memoir")
public class MemoirFacadeREST extends AbstractFacade<Memoir> {

    @PersistenceContext(unitName = "MovieMemoir1PU")
    private EntityManager em;

    public MemoirFacadeREST() {
        super(Memoir.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Memoir entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Memoir entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Memoir find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Memoir> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Memoir> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("findByMemoirid/{memoirid}")
    @Produces({"application/json"})
    public List<Memoir> findByMemoirid(@PathParam("memoirid") Integer memoirid) {
        Query query = em.createNamedQuery("Memoir.findByMemoirid");
        query.setParameter("memoirid", memoirid);
        return query.getResultList();
    }

    @GET
    @Path("findByMoviename/{moviename}")
    @Produces({"application/json"})
    public List<Memoir> findByMoviename(@PathParam("moviename") String moviename) {
        Query query = em.createNamedQuery("Memoir.findByMoviename");
        query.setParameter("moviename", moviename);
        return query.getResultList();
    }

    @GET
    @Path("findByMoviereleasedate/{moviereleasedate}")
    @Produces({"application/json"})
    public List<Memoir> findByMoviereleasedate(@PathParam("moviereleasedate") Date moviereleasedate) {
        Query query = em.createNamedQuery("Memoir.findByMoviereleasedate");
        query.setParameter("moviereleasedate", moviereleasedate);
        return query.getResultList();
    }

    @GET
    @Path("findByWatchdate/{watchdate}")
    @Produces({"application/json"})
    public List<Memoir> findByWatchdate(@PathParam("watchdate") Date watchdate) {
        Query query = em.createNamedQuery("Memoir.findByWatchdate");
        query.setParameter("watchdate", watchdate);
        return query.getResultList();
    }

    @GET
    @Path("findByComment/{comment}")
    @Produces({"application/json"})
    public List<Memoir> findByComment(@PathParam("comment") String comment) {
        Query query = em.createNamedQuery("Memoir.findByComment");
        query.setParameter("comment", comment);
        return query.getResultList();
    }

    @GET
    @Path("findByRatingscore/{ratingscore}")
    @Produces({"application/json"})
    public List<Memoir> findByRatingscore(@PathParam("ratingscore") Integer ratingscore) {
        Query query = em.createNamedQuery("Memoir.findByRatingscore");
        query.setParameter("ratingscore", ratingscore);
        return query.getResultList();
    }

    @GET
    @Path("findByPid/{pid}")
    @Produces({"application/json"})
    public List<Memoir> findByPid(@PathParam("pid") Integer pid) {
        Query query = em.createNamedQuery("Memoir.findByPid");
        query.setParameter("pid", pid);
        return query.getResultList();
    }

    @GET
    @Path("findByCid/{cid}")
    @Produces({"application/json"})
    public List<Memoir> findByCid(@PathParam("cid") Integer cid) {
        Query query = em.createNamedQuery("Memoir.findByCid");
        query.setParameter("cid", cid);
        return query.getResultList();
    }

    /**
     * task 3 c
     */
    @GET
    @Path("task3C_findMovieByCinemaname/{cinemaname}")
    @Produces({"application/json"})
    public List<Memoir> task3C_findMovieByCinemaname(@PathParam("cinemaname") String cinemaname) {
        TypedQuery<Memoir> q = em.createQuery("SELECT m FROM Memoir m WHERE m.cid.cinemaname = :cinemaname", Memoir.class);
        q.setParameter("cinemaname", cinemaname);
        return q.getResultList();
    }

    /**
     * task 3 d
     */
    @GET
    @Path("task3D_findMovieByCinemaname/{cinemaname}")
    @Produces({"application/json"})
    public List<Memoir> task3D_findMovieByCinemaname(@PathParam("cinemaname") String cinemaname) {
        Query query = em.createNamedQuery("Memoir.task3D_findMovieByCinemaname");
        query.setParameter("cinemaname", cinemaname);
        return query.getResultList();
    }

    /**
     * task 4 a
     */
    @GET
    @Path("task4A_findMoviesDuringPeriod/{personid}/{startingdate}/{endingdate}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object task4A_findMoviesDuringPeriod(@PathParam("personid") Integer personid, @PathParam("startingdate") String startingdate, @PathParam("endingdate") String endingdate) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date sdate = sd.parse(startingdate);
        Date edate = sd.parse(endingdate);
        TypedQuery<Object[]> q = em.createQuery("SELECT c.postcode, count(m.memoirid) FROM Memoir m JOIN Cinema c WHERE m.pid.personid = :personid AND m.watchdate BETWEEN :startingdate AND :endingdate group by c.postcode", Object[].class);
        q.setParameter("personid", personid);
        q.setParameter("startingdate", sdate);
        q.setParameter("endingdate", edate);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] row : queryList) {
            JsonObject recordObject = Json.createObjectBuilder().
                    add("postcode", (Integer) row[0])
                    .add("totalnumber", (Long) row[1]).build();
            arrayBuilder.add(recordObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    /**
     * task 4 b
     */
    @GET
    @Path("task4B_findNumberofMovieWatchedPerMonth/{personid}/{year}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object task4B_findNumberofMovieWatchedPerMonth(@PathParam("personid") Integer personid, @PathParam("year") String year) {
        TypedQuery<Object[]> q = em.createQuery("SELECT func('Month', m.watchdate), count(m.memoirid) FROM Memoir m WHERE m.pid.personid = :personid AND func('year', m.watchdate) = :year Group by func('Month', m.watchdate)", Object[].class);
        q.setParameter("personid", personid);
        q.setParameter("year", year);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] row : queryList) {
            JsonObject recordObject = Json.createObjectBuilder().
                    add("monthname", (String) row[0].toString())
                    .add("totalnumber", (Long) row[1]).build();
            arrayBuilder.add(recordObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    /**
     * task 4 c
     */
    @GET
    @Path("task4C_findHighestScoreMovie/{personid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object task4C_findHighestScoreMovie(@PathParam("personid") Integer personid) {
        TypedQuery<Object[]> q = em.createQuery("SELECT m.moviename, m.ratingscore, m.moviereleasedate FROM Memoir m WHERE m.pid.personid = :personid AND m.ratingscore = (SELECT MAX(m1.ratingscore) FROM Memoir m1 WHERE m1.pid.personid = :personid)", Object[].class);
        q.setParameter("personid", personid);
        q.setMaxResults(1);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] row : queryList) {
            JsonObject recordObject = Json.createObjectBuilder().
                    add("moviename", (String) row[0])
                    .add("ratingscore", (Integer) row[1])
                    .add("releasedate", (String) row[2].toString()).build();
            arrayBuilder.add(recordObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    /**
     * task 4 d
     */
    @GET
    @Path("task4D_findMoviesWatchedAndReleasedSameYear/{personid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object task4D_findMoviesWatchedAndReleasedSameYear(@PathParam("personid") Integer personid) {
        TypedQuery<Object[]> q = em.createQuery("SELECT m.moviename, func('Year', (m.moviereleasedate)) FROM Memoir m WHERE m.pid.personid = :personid AND func('year',(m.watchdate)) = func('year', (m.moviereleasedate))", Object[].class);
        q.setParameter("personid", personid);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] row : queryList) {
            JsonObject recordObject = Json.createObjectBuilder().
                    add("moviename", (String) row[0])
                    .add("releaseyear", (String) row[1].toString()).build();
            arrayBuilder.add(recordObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    /**
     * task 4 e
     */
    @GET
    @Path("task4E_findMoviesRemaked/{personid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object task4E_findMoviesRemaked(@PathParam("personid") Integer personid) {
        TypedQuery<Object[]> q = em.createQuery("select m1.moviename, func('year', m1.moviereleasedate) from Memoir m1 where m1.moviename in (select m2.moviename from Memoir m2 where func('year', m1.moviereleasedate) <> func('year', m2.moviereleasedate) and m1.moviename = m2.moviename and m1.pid.personid = :personid) group by m1.moviename, func('year', m1.moviereleasedate)", Object[].class);
        q.setParameter("personid", personid);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] row : queryList) {
            JsonObject recordObject = Json.createObjectBuilder().
                    add("moviename", (String) row[0])
                    .add("releaseyear", (String) row[1].toString()).build();
            arrayBuilder.add(recordObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    /**
     * task 4 f
     */
    @GET
    @Path("task4F_find5MoviesRecentYear/{personid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object task4F_find5MoviesRecentYear(@PathParam("personid") Integer personid) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date recentYear = c.getTime();
        TypedQuery<Object[]> q = em.createQuery("SELECT m.moviename, m.moviereleasedate, m.ratingscore FROM Memoir m WHERE m.pid.personid = :personid AND m.watchdate > :recentYear order by m.ratingscore desc", Object[].class);
        q.setParameter("personid", personid);
        q.setParameter("recentYear", recentYear);
        q.setMaxResults(5);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] row : queryList) {
            JsonObject recordObject = Json.createObjectBuilder().
                    add("moviename", (String) row[0])
                    .add("releasedate", (String) row[1].toString())
                    .add("ratingscore", (Integer) row[2]).build();
            arrayBuilder.add(recordObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
}
