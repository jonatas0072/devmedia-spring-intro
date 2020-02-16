package br.com.devmedia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.devmedia.domain.Musica;

@Repository
public class MusicaDaoImpl implements MusicaDao {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Musica musica) {
        em.persist(musica);
    }

    public List<Musica> recuperarPorPlaylist(Long playlistId) {
        return em.createQuery(
                "select m from Musica m where m.playlist.id = :playlistId",
                Musica.class).setParameter("playlistId", playlistId)
                .getResultList();
    }

    public Musica recuperarPorPlaylistIdEMusicaId(Long playlistId,
            Long musicaId) {
        return em.createQuery(
                "select m from Musica where m.playlist.id = :playlistId and m.id = :musicaId",
                Musica.class).setParameter("playlistId", playlistId)
                .setParameter("musicaId", musicaId).getSingleResult();
    }

    public void atualizar(Musica musica) {
        em.merge(musica);
    }

    public void excluir(Long musicaId) {
        em.remove(em.getReference(Musica.class, musicaId));
    }
}