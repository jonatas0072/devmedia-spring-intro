package br.com.devmedia.dao;

import java.util.List;

import br.com.devmedia.domain.Musica;

public interface MusicaDao {

    void salvar(Musica musica);
    
    List<Musica> recuperarPorPlaylist(Long playlistId);
    
    Musica recuperarPorPlaylistIdEMusicaId(Long playlistId, Long musicaId);
    
    void atualizar(Musica musica);
    
    void excluir (Long musica);
}
