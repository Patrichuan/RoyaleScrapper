package com.example.pat.royalescrapper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pat.royalescrapper.R;
import com.example.pat.royalescrapper.model.Match;

import java.util.List;

/**
 * Created by Pat on 16/04/2017.
 */

public class VerticalMatchAdapter extends RecyclerView.Adapter<VerticalMatchAdapter.MyViewHolder> {

    private List<Match> verticalList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView resulttv, scoretv;
        TextView meNametv, meClantv, meTrophiestv;
        TextView himNametv, himClantv, himTrophiestv;

        TextView meSpell1Leveltv, meSpell2Leveltv, meSpell3Leveltv, meSpell4Leveltv, meSpell5Leveltv,
                meSpell6Leveltv, meSpell7Leveltv, meSpell8Leveltv;

        TextView meSpell1Nametv, meSpell2Nametv, meSpell3Nametv, meSpell4Nametv, meSpell5Nametv,
                meSpell6Nametv, meSpell7Nametv, meSpell8Nametv;

        TextView himSpell1Leveltv, himSpell2Leveltv, himSpell3Leveltv, himSpell4Leveltv, himSpell5Leveltv,
                himSpell6Leveltv, himSpell7Leveltv, himSpell8Leveltv;

        TextView himSpell1Nametv, himSpell2Nametv, himSpell3Nametv, himSpell4Nametv, himSpell5Nametv,
                himSpell6Nametv, himSpell7Nametv, himSpell8Nametv;

        public MyViewHolder(View view) {
            super(view);
            resulttv = (TextView) view.findViewById(R.id.resulttv);
            scoretv = (TextView) view.findViewById(R.id.scoretv);

            meNametv = (TextView) view.findViewById(R.id.meNametv);
            meClantv = (TextView) view.findViewById(R.id.meClantv);
            meTrophiestv = (TextView) view.findViewById(R.id.meTrophiestv);

            himNametv = (TextView) view.findViewById(R.id.himNametv);
            himClantv = (TextView) view.findViewById(R.id.himClantv);
            himTrophiestv = (TextView) view.findViewById(R.id.himTrophiestv);

            meSpell1Nametv = (TextView) view.findViewById(R.id.meSpell1Nametv);
            meSpell2Nametv = (TextView) view.findViewById(R.id.meSpell2Nametv);
            meSpell3Nametv = (TextView) view.findViewById(R.id.meSpell3Nametv);
            meSpell4Nametv = (TextView) view.findViewById(R.id.meSpell4Nametv);
            meSpell5Nametv = (TextView) view.findViewById(R.id.meSpell5Nametv);
            meSpell6Nametv = (TextView) view.findViewById(R.id.meSpell6Nametv);
            meSpell7Nametv = (TextView) view.findViewById(R.id.meSpell7Nametv);
            meSpell8Nametv = (TextView) view.findViewById(R.id.meSpell8Nametv);

            meSpell1Leveltv = (TextView) view.findViewById(R.id.meSpell1Leveltv);
            meSpell2Leveltv = (TextView) view.findViewById(R.id.meSpell2Leveltv);
            meSpell3Leveltv = (TextView) view.findViewById(R.id.meSpell3Leveltv);
            meSpell4Leveltv = (TextView) view.findViewById(R.id.meSpell4Leveltv);
            meSpell5Leveltv = (TextView) view.findViewById(R.id.meSpell5Leveltv);
            meSpell6Leveltv = (TextView) view.findViewById(R.id.meSpell6Leveltv);
            meSpell7Leveltv = (TextView) view.findViewById(R.id.meSpell7Leveltv);
            meSpell8Leveltv = (TextView) view.findViewById(R.id.meSpell8Leveltv);

            himSpell1Nametv = (TextView) view.findViewById(R.id.himSpell1Nametv);
            himSpell2Nametv = (TextView) view.findViewById(R.id.himSpell2Nametv);
            himSpell3Nametv = (TextView) view.findViewById(R.id.himSpell3Nametv);
            himSpell4Nametv = (TextView) view.findViewById(R.id.himSpell4Nametv);
            himSpell5Nametv = (TextView) view.findViewById(R.id.himSpell5Nametv);
            himSpell6Nametv = (TextView) view.findViewById(R.id.himSpell6Nametv);
            himSpell7Nametv = (TextView) view.findViewById(R.id.himSpell7Nametv);
            himSpell8Nametv = (TextView) view.findViewById(R.id.himSpell8Nametv);

            himSpell1Leveltv = (TextView) view.findViewById(R.id.himSpell1Leveltv);
            himSpell2Leveltv = (TextView) view.findViewById(R.id.himSpell2Leveltv);
            himSpell3Leveltv = (TextView) view.findViewById(R.id.himSpell3Leveltv);
            himSpell4Leveltv = (TextView) view.findViewById(R.id.himSpell4Leveltv);
            himSpell5Leveltv = (TextView) view.findViewById(R.id.himSpell5Leveltv);
            himSpell6Leveltv = (TextView) view.findViewById(R.id.himSpell6Leveltv);
            himSpell7Leveltv = (TextView) view.findViewById(R.id.himSpell7Leveltv);
            himSpell8Leveltv = (TextView) view.findViewById(R.id.himSpell8Leveltv);
        }
    }


    public VerticalMatchAdapter(Context context, List<Match> verticalList) {
        this.context = context;
        this.verticalList = verticalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.resulttv.setText(verticalList.get(position).getResult());
        holder.scoretv.setText(verticalList.get(position).getScore());

        holder.meNametv.setText(verticalList.get(position).getPlayer1().getName());
        holder.meClantv.setText(verticalList.get(position).getPlayer1().getClan());
        holder.meTrophiestv.setText(String.valueOf(verticalList.get(position).getPlayer1().getLastKnownTrophies()));

        holder.himNametv.setText(verticalList.get(position).getPlayer2().getName());
        holder.himClantv.setText(verticalList.get(position).getPlayer2().getClan());
        holder.himTrophiestv.setText(String.valueOf(verticalList.get(position).getPlayer2().getLastKnownTrophies()));

        holder.meSpell1Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(0).getLevel())+" - ");
        holder.meSpell2Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(1).getLevel())+" - ");
        holder.meSpell3Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(2).getLevel())+" - ");
        holder.meSpell4Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(3).getLevel())+" - ");
        holder.meSpell5Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(4).getLevel())+" - ");
        holder.meSpell6Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(5).getLevel())+" - ");
        holder.meSpell7Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(6).getLevel())+" - ");
        holder.meSpell8Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer1Deck().getSpells().get(7).getLevel())+" - ");

        holder.meSpell1Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(0).getName());
        holder.meSpell2Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(1).getName());
        holder.meSpell3Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(2).getName());
        holder.meSpell4Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(3).getName());
        holder.meSpell5Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(4).getName());
        holder.meSpell6Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(5).getName());
        holder.meSpell7Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(6).getName());
        holder.meSpell8Nametv.setText(verticalList.get(position).getPlayer1Deck().getSpells().get(7).getName());

        holder.himSpell1Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(0).getLevel())+" - ");
        holder.himSpell2Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(1).getLevel())+" - ");
        holder.himSpell3Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(2).getLevel())+" - ");
        holder.himSpell4Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(3).getLevel())+" - ");
        holder.himSpell5Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(4).getLevel())+" - ");
        holder.himSpell6Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(5).getLevel())+" - ");
        holder.himSpell7Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(6).getLevel())+" - ");
        holder.himSpell8Leveltv.setText("L"+String.valueOf(verticalList.get(position).getPlayer2Deck().getSpells().get(7).getLevel())+" - ");

        holder.himSpell1Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(0).getName());
        holder.himSpell2Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(1).getName());
        holder.himSpell3Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(2).getName());
        holder.himSpell4Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(3).getName());
        holder.himSpell5Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(4).getName());
        holder.himSpell6Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(5).getName());
        holder.himSpell7Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(6).getName());
        holder.himSpell8Nametv.setText(verticalList.get(position).getPlayer2Deck().getSpells().get(7).getName());
    }

    @Override
    public int getItemCount() {
        return verticalList.size();
    }
}